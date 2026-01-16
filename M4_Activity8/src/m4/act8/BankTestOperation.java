package m4.act8;

@FunctionalInterface
public interface BankTestOperation {
	
	 void execute() throws InvalidAmountException, InsufficientFundsException;

}
