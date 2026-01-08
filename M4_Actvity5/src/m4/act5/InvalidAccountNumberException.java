package m4.act5;
import java.io.Serializable;
public class InvalidAccountNumberException extends Exception implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// No args constructor
	public InvalidAccountNumberException() {
		
	}
	
	public InvalidAccountNumberException(String message) {
		super(message);
		
	}
	

}
