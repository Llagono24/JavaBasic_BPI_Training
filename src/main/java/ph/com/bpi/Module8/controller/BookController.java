package ph.com.bpi.Module8.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import ph.com.bpi.Module8.model.Book;
import ph.com.bpi.Module8.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	BookService bookService = new BookService();
	
	@GetMapping
	public List<Book> initialBooks() {
		return bookService.initialBooks();
	}
	
	//for Activity8.3
	@GetMapping("/{id}")
	public Book getBook(@PathVariable String id) {
		return bookService.findBook(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

}
