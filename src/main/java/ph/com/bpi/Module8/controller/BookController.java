package ph.com.bpi.Module8.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ph.com.bpi.Module8.dto.BookDTO;
import ph.com.bpi.Module8.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	
	private final BookService bookService;
	
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@GetMapping
	public List<BookDTO> initialBooks() {
		return bookService.initialBooks();
	}
	
	//for Activity8.3
	@GetMapping("/{id}")
	public BookDTO getBook(@PathVariable String id) {
		return bookService.findBook(id);
	}
	
	//for Activity8.4
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.FOUND)
	public List<BookDTO> searchBook(@RequestParam String title, @RequestParam String author) {
		return bookService.searchBook(title, author);
	}
	
	//For Activity8.5
	@ResponseBody
	@GetMapping("/display")
	public List<BookDTO> displayBooks(){
		return bookService.displayBooks();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO createBook(@RequestBody BookDTO book) {
		return bookService.saveBook(book);
	}
	


}
