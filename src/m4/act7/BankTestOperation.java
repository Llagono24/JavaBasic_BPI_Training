package m4.act7;

@FunctionalInterface
public interface BankTestOperation {
	
	 void execute() throws InvalidAmountException, InsufficientFundsException;

}
