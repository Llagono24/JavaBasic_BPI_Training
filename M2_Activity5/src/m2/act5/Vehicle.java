package m2.act5;

public abstract class Vehicle implements Refuelable  {
	
	private int numberOfWheels;
	private String brand;
	
	abstract void startEngine();
	
	void destroy() {
		System.out.println("This vehicle is destroyed!");
	}
	
	//setters and getters
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
		
	}
	
	public int getNumberOfWheels() {
		return this.numberOfWheels;
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
		
	}
	
	public String getBrand() {
		return this.brand;
	}
	

}
