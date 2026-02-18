package ph.com.bpi.Module8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private LoggerService loggerService;
	
	// Setter Injection
	@Autowired
	public void setBookService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	
	public void logMessage(String msg) {
		loggerService.log(msg);
	}
	

}
