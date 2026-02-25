package ph.com.bpi.Module8.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.bpi.Module8.model.Book;

@Service
public class BookService {
	List<Book> bookList = new ArrayList<Book>();
	
	
	public List<Book> initialBooks() {
		
		if(bookList == null || bookList.isEmpty() || bookList.size() == 0) {
			initializeBooks();
			
		}
		
		return bookList;
		
	}
	
	public List<Book> initializeBooks() {
		Book book1 = new Book("1", "The Lord of the Rings", "J.R.R. Tolkien");
		Book book2 = new Book("2", "Siddhartha", "Hermann Hesse");
		Book book3 = new Book("3", "Harry Potter and the Philosopher's Stone", "J.K. Rowling");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		return bookList;
	}
	
	public Book findBook(String id) {
		Book book1 = new Book();
		
		for(int i = 0; i < bookList.size(); i++) {
			
			if(bookList.get(i).getId().equals(id)) {
				book1 = bookList.get(i);	
			}
		}
		
		return book1;
	}
	
	public Book saveBook(Book book) {

		bookList.add(book);
		
		return book;
	}
	

}
