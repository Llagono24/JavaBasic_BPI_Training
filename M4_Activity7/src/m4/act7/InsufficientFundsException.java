package m4.act7;

public class InsufficientFundsException extends Exception {
	
	private double balance; 
	private double requestedAmount;
	
	public InsufficientFundsException(String message, double balance, double requestedAmount) {
		super(message);
		this.balance = balance;
		this.requestedAmount = requestedAmount;
	}
	
	
	public double getBalance() {
		return this.balance;
	}

	public double getRequestedAmount() {
		return this.requestedAmount;
	}
	
}
