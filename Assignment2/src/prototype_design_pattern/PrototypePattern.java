package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Create a class called Vehicle that implements Cloneable
class Vehicle implements Cloneable {
  private List<String> vehicleList; // List to store vehicle data

  public Vehicle() {
    this.vehicleList = new ArrayList<String>(); // Initialize the vehicle list
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list; // Initialize the vehicle list with provided data
  }

  public void insertData() {
    // Insert sample vehicle data into the list
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList; // Get the vehicle list
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    for (String s : this.getVehicleList()) {
      tempList.add(s); // Create a deep copy of the vehicle list
    }

    return new Vehicle(tempList);
  }
}

// Create a public class called PrototypePattern
public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle a = new Vehicle(); // Create a vehicle instance
    a.insertData(); // Insert data into the vehicle list

    Vehicle b = (Vehicle) a.clone(); // Clone the vehicle instance
    List<String> list = b.getVehicleList(); // Get the vehicle list from the cloned instance
    list.add("Honda new Amaze"); // Add a new vehicle to the cloned list

    System.out.println(a.getVehicleList()); // Print the original vehicle list
    System.out.println(list); // Print the modified cloned list

    b.getVehicleList().remove("Audi A4"); // Remove a vehicle from the cloned list
    System.out.println(list); // Print the modified cloned list
    System.out.println(a.getVehicleList()); // Print the original vehicle list
  }
}
