package m2.act6;

public class Main_Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle car1 = new Car();
		Vehicle truck1 = new Truck();
		
		//Car attributes and methods
		car1.setBrand("Honda");
		car1.setNumberOfWheels(4);
		System.out.println("This car is a "+car1.getNumberOfWheels()+" wheeler and has brand of "+car1.getBrand());
		car1.startEngine();
		car1.refuel();
		
		//Truck attributes and methods
		truck1.setBrand("Mitsubishi");
		truck1.setNumberOfWheels(8);
		System.out.println("This truck is a "+truck1.getNumberOfWheels()+" wheeler and has brand of "+truck1.getBrand());
		truck1.startEngine();
		truck1.refuel();
		
		//Call method destroy
		destroyVehicle(car1);
		destroyVehicle(truck1);
		
	}
	
	
	public static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
	}

}
