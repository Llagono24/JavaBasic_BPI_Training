package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	 // Start server on port 4567 (default)
        port(4568);
        
        // add routes here


        // Get Profile List
        
        get("/movies", (req, res) -> {
        	res.type("application/json");// define the MIME type of the response
        	// we're telling the client that the response
        	// is of JSON format
        	// return a map (A map is basically a JSON formatted object)
        	Map<String, Object> response = new HashMap<>();

        	Movie movie3 = new Movie(3L, "FPJ's Probinsyano", "Coco Martin", "2025-10-10");
        	Movie movie4 = new Movie(4L, "Haikyuu", "Susumu Mitsunaka", "2026-03-01");

        	List<Movie> movieList = movieRepository.findAll();
        	movieList.add(movie3);
        	movieList.add(movie4);
        	response.put("Movie", movieList);
        	return JsonUtil.toJson(response);
        });
        
        // We create a route for checking if the server is active.
        get("/check-connection", (req, res) -> {
            res.type("application/json");	// define the MIME type of the response
            								// we're telling the client that the response
            								// is of JSON format

            // return a map (A map is basically a JSON formatted object)
            Map<String, String> response = new HashMap<>();
            response.put("status", "Server is running");
            
            return JsonUtil.toJson(response);
        });
        


        
        // Create Profile List
        post("/movies", (req, res) -> {
        	res.type("application/json");
        	
            Map<String, Object> response = new HashMap<>();
        	
        	if(req.body() == null || req.body().isBlank()) {
        		res.status(400);
        		response.put("STATUS", "ERROR");
                response.put("data", null);
                response.put("message", "Request body cannot be null");
                
                return JsonUtil.toJson(response);
        	}
        	
        	List<Movie> movieList = movieRepository.findAll();
        	Movie movie = JsonUtil.fromJson(req.body(), Movie.class);
        	movieList.add(movie);
        	
            response.put("status", "Success");
            response.put("data", movieList);

        	return JsonUtil.toJson(response);
        });
        
        
        
        
    }
    
    

}
