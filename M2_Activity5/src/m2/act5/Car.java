package m2.act5;

public class Car extends Vehicle implements Refuelable  {
	
	@Override
	public void startEngine() {
		System.out.println("Car engine is starting...");
		
	}
	
	@Override
	public void refuel() {
		System.out.println("Car is refueling...");
		
	}


}
