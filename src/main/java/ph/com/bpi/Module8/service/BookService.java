package ph.com.bpi.Module8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	
	// Field Injection
	@Autowired
	private LoggerService loggerService;
	
	public void logMessage(String msg) {
		loggerService.log(msg);
	}
	

}
