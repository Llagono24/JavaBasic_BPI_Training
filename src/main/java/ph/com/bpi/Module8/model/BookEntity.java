package ph.com.bpi.Module8.model;


import jakarta.persistence.Entity; 
import jakarta.persistence.Id; 
import lombok.Data; 

@Entity 
@Data
public class BookEntity {
	
	@Id
	private String id;
	private String title;
	private String author;
	
	public BookEntity(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public BookEntity() {

	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	

}
