package m4.act2;

public class ATMSystem {

	
	static double[] accounts = {10000, 15000, 20000};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("=== ATM Withdrawal System ===\n");
		
		System.out.println("Test 1: Valid Withdrawal");
		processWithdrawal("1", "5000");
		System.out.println("Test 2: Invalid Account index");
		processWithdrawal("abc", "5000");
		System.out.println("Test 3: Account not found");
		processWithdrawal("10", "5000");
		System.out.println("Test 4: Insufficient funds");
		processWithdrawal("1", "20000");
		
		System.out.println("=== All Tests Completed! ===");
		
		
	}
	
	public static void processWithdrawal(String accountIndex, String amountInput) {
		
		try {
			System.out.println("Account="+accountIndex+", Amount="+amountInput);
			int index = Integer.parseInt(accountIndex);
			double balance = accounts[index];
			System.out.println("Current balance: ₱"+balance);
			double amount = Double.parseDouble(amountInput);
			System.out.println("Withdrawal: ₱"+amount);
			
			if(amount > balance) {
				System.out.println("Insufficient funds! Cannot withdraw ₱"+amount+"\n");
			}else {
				accounts[index] = (balance - amount);
				System.out.println("New Balance: "+accounts[index]);
				System.out.println("Withdrawal successful!\n");
			}
			
		}catch(NumberFormatException e) {
			System.out.println("Error: Invalid input");
			System.out.println("Please enter valid numbers\n");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Account not found");
			System.out.println("Invalid account index\n");
		}catch(Exception e) {
			System.out.println("Transaction failed\n");
		}
			

		
	}

}
