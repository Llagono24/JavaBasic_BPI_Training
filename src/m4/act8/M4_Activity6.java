package m4.act8;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class M4_Activity6 {

	private static final Logger logger = LoggerFactory.getLogger(M4_Activity6.class);
	
	static BankAccount bankAccount = new BankAccount();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		runTest(() -> deposit(5000), "Deposit");
		runTest(() -> withdraw(3000), "Withdrawal");
		runTest(() -> deposit(-500), "Deposit");
		runTest(() -> withdraw(20000), "Withdrawal");
		runTest(() -> deposit(60000), "Deposit");
		


	}
	
	
	public static void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
		
		try {
			logger.info("Withdrawal requested: ₱{}", amount);

			if(amount < 0) {
				throw new InvalidAmountException("Withdrawal failed: Invalid amount");
			}else if(amount > bankAccount.getBalance()) {
				throw new InsufficientFundsException("Insufficient funds for withdrawal", bankAccount.getBalance(), amount);
			}else {
				bankAccount.setBalance(bankAccount.getBalance() - amount);
				logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, bankAccount.getBalance());

			}
		}
		catch(InvalidAmountException e) {
			logger.error(e.getMessage());
		}catch(InsufficientFundsException e) {
			logger.warn("Insufficient funds: ₱{} available", e.getBalance());
			logger.error("Deposit failed: Insufficient funds for withdrawal", e);
		}
	}
	
	
	public static void deposit(double amount) throws InvalidAmountException {
		
		try {
			logger.info("Deposit requested: ₱{}", amount);
			if(amount <= 0) {
				throw new InvalidAmountException("Deposit amount must be positive");
			}if(amount > 50000) {
				logger.warn("Large deposit: ₱{} - requires verification", amount);
				bankAccount.setBalance(bankAccount.getBalance() + amount);
				logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, bankAccount.getBalance());
			}else {
				bankAccount.setBalance(bankAccount.getBalance() + amount);
				logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, bankAccount.getBalance());
			}
			
		}catch(InvalidAmountException e) {
			logger.error("Invalid deposit amount: ₱{}", amount);
			logger.error("Deposit failed: Deposit amount must be positive", e);

		}	
		
	}
	
	
	public static void runTest(BankTestOperation operation, String operationName) {
		
		try{
			
			operation.execute();
			
		}catch(InvalidAmountException e) {
			logger.error(e.getMessage());
		}catch(InsufficientFundsException e) {
			logger.error(e.getMessage());
		}
	}

}


