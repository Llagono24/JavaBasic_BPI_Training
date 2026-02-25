package ph.com.bpi.Module8.service;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {
	
	
	public SingletonService() {
		System.out.println("SingletonService Created");
	}

}
