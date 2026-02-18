package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import ph.com.bpi.training.repository.MovieRepository;
import ph.com.bpi.training.service.MovieService;
import ph.com.bpi.training.util.EntityManagerUtil;


import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final MovieService movieService = new MovieService();
	
	 
    public static void main(String[] args) {

    	 // Start server on port 4567 (default)
        port(4568);
        
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	
    	movieService.registerRoutes();
        
        
        
    }
    
    

}
