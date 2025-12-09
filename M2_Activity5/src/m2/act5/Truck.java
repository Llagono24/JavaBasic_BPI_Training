package m2.act5;

public class Truck extends Vehicle implements Refuelable  {
	
	@Override
	public void startEngine() {
		System.out.println("Truck engine is starting...");
		
	}
	
	@Override
	public void refuel() {
		System.out.println("Truck is refueling...");
		
	}
}
