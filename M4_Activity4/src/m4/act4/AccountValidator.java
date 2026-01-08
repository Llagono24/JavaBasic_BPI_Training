package m4.act4;

public class AccountValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test case 1 valid
		try {
			validateAccountNumber("1234567890");

		}catch(NullPointerException npe) {
			System.out.println("Error: "+npe.getMessage());
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		//Test case 2 invalid number
		try {
			validateAccountNumber("123");

		}catch(NullPointerException npe) {
			System.out.println("Error: "+npe.getMessage());
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		//Test case 3 invalid null
		try {
			validateAccountNumber(null);

		}catch(NullPointerException npe) {
			System.out.println("Error: "+npe.getMessage());
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		

		
	}
	
	// Method to validate account number
	public static void validateAccountNumber(String accountNumber) throws Exception {
		
		if(accountNumber == null) {
			throw new NullPointerException("Cannot be null!");
		}else if(accountNumber.length() != 10) {
			throw new Exception("Must be 10 digits");
		}else {
			System.out.println("Valid account: "+accountNumber);
		}
		
	} // End of validateAccountNumber

}
