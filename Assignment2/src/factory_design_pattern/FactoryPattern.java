package factory_design_pattern;

// Create an abstract class called Vehicle
abstract class Vehicle {
	public abstract int getWheel(); // Declare an abstract method to get the number of wheels

	// Override the toString method to provide a string representation of the vehicle
	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

// Create a class Car that extends Vehicle
class Car extends Vehicle {
	int wheel;

	// Constructor for Car
	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Create a class Bike that extends Vehicle
class Bike extends Vehicle {
	int wheel;

	// Constructor for Bike
	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Create a class VehicleFactory for creating instances of vehicles
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel); // Create and return a Car instance
		} else if (type.equals("bike")) {
			return new Bike(wheel); // Create and return a Bike instance
		}
		return null; // Return null if the type is not recognized
	}
}

// Create a public class called FactoryPattern
public class FactoryPattern {
	public static void main(String[] args) {
		// Use the VehicleFactory to create a Car instance with 4 wheels and print it
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		// Use the VehicleFactory to create a Bike instance with 2 wheels and print it
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
