package m4.act5;

public class AccountValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=== Account number Validation Test ===\n");
		
		testValidation("1: Valid Account", "1234567890");
		testValidation("2: Too short", "123");
		testValidation("3: Contains letters", "12345ABC90");
		testValidation("4: Contains spaces", "1234 567890");
		testValidation("5: Null value", null);

	}
	
	public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
		
			if(accountNumber == null) {
				throw new NullPointerException("Error: Account number cannot be null");
			}
			
			for (char c : accountNumber.toCharArray()) {
				if (!Character.isDigit(c)) {
					throw new InvalidAccountFormatException("Error: Account number must contain only digits\n");
				}
			}
			
			if(accountNumber.length() != 10) {
				throw new InvalidAccountNumberException("Account number must be exactly 10 digits\n");
			}else {
				System.out.println("Valid account number: "+accountNumber+"\n");
					
			}

	}
	
	public static void testValidation(String testName, String accountNumber) {
		
		System.out.println("Test: "+testName+" ("+accountNumber+")");
		
		try {
			validateAccountNumber(accountNumber);
		
		}catch(InvalidAccountNumberException e) {
			System.out.println(e.getMessage());
		}catch(InvalidAccountFormatException e) {
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
