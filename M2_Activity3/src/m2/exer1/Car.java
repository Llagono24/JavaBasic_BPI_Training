/**
 * 
 */
package m2.exer1;

public class Car {

	String Name;
	String plateNum;
	double price;
	
	
	void travel() {
		System.out.println("I am driving my car to travel");
	}
	
	public Car(String Name, String plateNum, double price) {
		this.Name = Name;
		this.plateNum = plateNum;
		this.price = price;
	}
}
