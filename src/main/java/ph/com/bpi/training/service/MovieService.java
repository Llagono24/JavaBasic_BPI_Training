package ph.com.bpi.training.service;

import jakarta.persistence.EntityManager;
import ph.com.bpi.training.controller.MovieController;
import ph.com.bpi.training.repository.MovieRepository;
import ph.com.bpi.training.util.EntityManagerUtil;

public class MovieService {
	
	MovieController movieController = new MovieController();
	
	// intialize entityManager;
    EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	
	
    // initialize movieRepository
	MovieRepository movieRepository = new MovieRepository(em);
	
	public void registerRoutes() {
		movieController.registerRoutes();
	}
	
	
	
	
}
