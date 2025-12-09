package m2.act6;

public abstract class Vehicle implements Refuelable {
	
	private int numberOfWheels;
	private String brand;
	
	public Vehicle() {
			
	}
	public Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
	}
	
	
	abstract void startEngine();
	
	
	public void destroy() {
		System.out.println("This brand of vehicle "+this.getBrand()+" and "+this.getNumberOfWheels()+" wheeler is destroyed");
		
	}
	
	// Setters and Getters
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
