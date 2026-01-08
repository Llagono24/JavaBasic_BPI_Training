package m4.act5;
import java.io.Serializable;
public class InvalidAccountFormatException extends RuntimeException implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//No args constructor
	public InvalidAccountFormatException() {
		
		
	}
	
	//With args constructor
	public InvalidAccountFormatException(String message) {
		super(message);
		
		
	}
	

}
