package ph.com.bpi.Module8.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import ph.com.bpi.Module8.model.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@GetMapping
	public List<Book> initializeBooks() {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book("B1", "The Lord of the Rings", "J.R.R. Tolkien");
		Book book2 = new Book("B2", "Siddhartha", "Hermann Hesse");
		Book book3 = new Book("B3", "Harry Potter and the Philosopher's Stone", "J.K. Rowling");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		return bookList;
	}
	
//	@GetMapping("/{id}")
//	public Book getOneBook(@PathVariable String id) {
//		
//	}

}
