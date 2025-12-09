package m2.act6;

public class Car extends Vehicle implements Refuelable {
	public Car() {
		
	}
	
	public Car(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}
	
	@Override
	public void startEngine() {
		System.out.println("Starting Engine of car...");
	}
	
	@Override
	public void refuel() {
		System.out.println("Refueling the car...");
	}
	
	@Override
	public void destroy() {
		System.out.println("This brand of car "+this.getBrand()+" and "+this.getNumberOfWheels()+" wheeler is destroyed");
		
	}

}
