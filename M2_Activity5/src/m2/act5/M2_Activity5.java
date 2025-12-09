package m2.act5;

public class M2_Activity5 {

	public static void main(String[] args) {
		
		// Create instance of Car and Truck
		Vehicle car1 = new Car();
		Vehicle truck1 = new Truck();
		
		//call abstract method
		car1.startEngine();
		truck1.startEngine();
		
		//Car setters and getters
		car1.setNumberOfWheels(4);
		car1.setBrand("Honda");
		System.out.println("Vehicle with brand of "+car1.getBrand()+" has "+car1.getNumberOfWheels()+" wheels.");
		
		//Truck setters and getters
		truck1.setNumberOfWheels(6);
		truck1.setBrand("Mitsubishi");
		System.out.println("Vehicle with brand of "+truck1.getBrand()+" has "+truck1.getNumberOfWheels()+" wheels.");
		
		//interface Refuelable method
		car1.refuel();
		truck1.refuel();
		
		//call destroyVehicle method
		destroyVehicle(car1);
		destroyVehicle(truck1);
		
		
		
	}
	
	// create method destroyVehicle
	public static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
		
	}

}
