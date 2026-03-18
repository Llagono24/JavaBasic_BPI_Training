package ph.com.bpi.Module8.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.bpi.Module8.dto.BookDTO;
import ph.com.bpi.Module8.model.BookEntity;
import ph.com.bpi.Module8.repository.BookRepository;
import ph.com.bpi.Module8.mapper.BookMapper;

@Service
public class BookService {
	private final BookMapper bookMapper;
	private final BookRepository bookRepository;
	
	List<BookEntity> bookList = new ArrayList<BookEntity>();
	List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
	
	public BookService(BookMapper bookMapper, BookRepository bookRepository) {
		this.bookMapper = bookMapper;
		this.bookRepository = bookRepository;
	}
	
	
	
	public List<BookDTO> initialBooks() {
		
		if(bookList == null || bookList.isEmpty() || bookList.size() == 0) {
			initializeBooks();
		}
		
		for(BookEntity book : bookList) {
			bookDTOList.add(bookMapper.toDTO(book));
		}
		List<BookEntity> bookList1 = bookRepository.saveAll(bookList);
		System.out.println(bookList1.size());
		return bookDTOList;
		
	}
	
	public List<BookEntity> initializeBooks() {
		BookEntity book1 = new BookEntity("1", "The Lord of the Rings", "J.R.R. Tolkien");
		BookEntity book2 = new BookEntity("2", "Siddhartha", "Hermann Hesse");
		BookEntity book3 = new BookEntity("3", "Harry Potter and the Philosopher's Stone", "J.K. Rowling");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		return bookList;
	}
	
	public BookDTO findBook(String id) {
		BookEntity book1 = new BookEntity();
		
		for(int i = 0; i < bookList.size(); i++) {
			
			if(bookList.get(i).getId().equals(id)) {
				book1 = bookList.get(i);	
			}
		}
		
		return bookMapper.toDTO(book1);
	}
	
	public BookDTO saveBook(BookDTO book) {
		bookDTOList.add(book);
		
		bookList.add(bookMapper.toEntity(book));
		
		return book;
	}
	
	//search book
	public List<BookDTO> searchBook(String title, String author) {
		
		List<BookEntity> bookList1 = new ArrayList<BookEntity>();
		List<BookDTO> bookDTOList1 = new ArrayList<BookDTO>();
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(title) && bookList.get(i).getAuthor().equals(author)) {
				bookList1.add(bookList.get(i));
			}
		}
		
		for(BookEntity book : bookList1) {
			bookDTOList1.add(bookMapper.toDTO(book));
		}
	
		return bookDTOList1;
		 
	}
	
	public List<BookDTO> displayBooks(){
		
		
		List<BookDTO> bookDTOList1 = new ArrayList<BookDTO>();
		List<BookEntity> bookList1 = bookRepository.findAll();
		
		for(BookEntity book : bookList1) {
			bookDTOList1.add(bookMapper.toDTO(book));
		}
		

		return bookDTOList1;
	}
	
	
	

}
