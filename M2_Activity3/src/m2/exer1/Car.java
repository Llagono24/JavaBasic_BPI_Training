/**
 * 
 */
package m2.exer1;

public class Car {
	
	private String carType;
	private String color;
	private double price;
	
	// No Arguments class Constructor
	public Car() {
		
		
	}
	
	// With Parameters class Constructor
	public Car(String carType, String color, double price) {
		
		this.carType = carType;
		this.color = color;
		this.price = price;
		
	}
	
	// method showInfo
	void showInfo() {
		System.out.println("============= Car Information ============");
		System.out.println("Car Type: "+this.carType + "\nCar Color: "+this.color+"\nCar Price: "+this.price);
		System.out.println("==========================================");
		
	}
	
	// getters and setters
	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
