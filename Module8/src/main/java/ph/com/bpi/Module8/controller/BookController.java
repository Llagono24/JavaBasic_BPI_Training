package ph.com.bpi.Module8.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import ph.com.bpi.Module8.model.Book;
import ph.com.bpi.Module8.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	BookService bookService = new BookService();
	
	@GetMapping
	public List<Book> initializeBooks() {
		return bookService.initialBooks();
	}

	
	@GetMapping("/{id}")
	public Book getOneBook(@PathVariable String id) {
		return bookService.findBook(id);
	}

}
