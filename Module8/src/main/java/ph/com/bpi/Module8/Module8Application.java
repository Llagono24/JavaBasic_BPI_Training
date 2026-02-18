package ph.com.bpi.Module8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ph.com.bpi.Module8.service.BookService;

@SpringBootApplication
public class Module8Application {
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Module8Application.class, args);
		
		BookService bookService = context.getBean(BookService.class);
		
		bookService.logMessage("Hello Spring!");
		
	}

}
