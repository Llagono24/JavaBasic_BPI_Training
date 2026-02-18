package ph.com.bpi.Module8.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private final LoggerService loggerService;
	
	// Constructor Injection
	public BookService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	
	public void logMessage(String msg) {
		loggerService.log(msg);
	}
	

}
