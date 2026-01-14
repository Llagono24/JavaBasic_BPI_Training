package m4.act6;

@FunctionalInterface
public interface BankTestOperation {
	
	 void execute() throws InvalidAmountException, InsufficientFundsException;

}
