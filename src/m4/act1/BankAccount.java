/**
 * 
 */
package m4.act1;

/**
 * 
 */
public class BankAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("=== Bank Account Name Display ===\n");
		
		testCase("ACC-001");
		testCase("ACC-999");
		
		System.out.println("=== Program completed successfully ===");

	}
	
	
	// Method to get the account name for acct no
	public static String getAccountName(String acctNumber) {
		
		if(acctNumber.equals("ACC-001")) {
			return "Juan Dela Cruz";
		}else if(acctNumber.equals("ACC-002")) {
			return "Maria Santos";
		}else {
			return null;
		}
		
		
	}
	
	// Method testCase with try catch
	public static void testCase(String accountNumber) {
		System.out.println("Looking up account: :"+accountNumber);
		try {
			String name = getAccountName(accountNumber);
			name = name.toUpperCase();
			System.out.println("Account holder: "+name+"\n");
		}catch(NullPointerException e) {
			System.out.println("Error: Account not found!\n");
		}
		
	}

}
