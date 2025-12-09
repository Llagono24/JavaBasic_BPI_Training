package m2.act6;

public class Truck extends Vehicle implements Refuelable {
	
	public Truck() {
		
	}
	
	public Truck(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}
	
	@Override
	public void startEngine() {
		System.out.println("Starting Engine of truck...");
	}
	
	@Override
	public void refuel() {
		System.out.println("Refueling truck...");
	}
	
	@Override
	public void destroy() {
		System.out.println("This brand of truck "+this.getBrand()+" and "+this.getNumberOfWheels()+" wheeler is destroyed");
		
	}
	
	
}
