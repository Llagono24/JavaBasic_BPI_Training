package ph.com.bpi.Module8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//import ph.com.bpi.Module8.service.BookService;
import ph.com.bpi.Module8.service.PrototypeService;
import ph.com.bpi.Module8.service.SingletonService;

@SpringBootApplication
public class Module8Application {
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Module8Application.class, args);
		
//		BookService bookService = context.getBean(BookService.class);
//		
//		bookService.initialBooks();
//		
		
		// Get Singleton Beans
		SingletonService s1 = context.getBean(SingletonService.class);
		SingletonService s2 = context.getBean(SingletonService.class);
		// Get Prototype Beans
		PrototypeService p1 = context.getBean(PrototypeService.class);
		PrototypeService p2 = context.getBean(PrototypeService.class);
		System.out.println("Singleton Same? " + (s1 == s2));
		System.out.println("Prototype Same? " + (p1 == p2));
	}

}
