package ph.com.bpi.Module8.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.bpi.Module8.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
	
	
	
	

}
