package ph.com.bpi.Module8.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeService {

	public PrototypeService() {
		System.out.println("PrototypeService Created");
	}
	
}
