package ph.com.bpi.Module8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

	
	@Value("${welcome.msg}")
	private String welcomeMessage;
	
	@GetMapping("/welcome")
	public String welcomeMessage() {
		return welcomeMessage;
	}
	
	
	
}
