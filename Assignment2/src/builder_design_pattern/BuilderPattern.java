package builder_design_pattern;

// Create a class called Vehicle
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  // Get the engine of the vehicle
  public String getEngine() {
    return this.engine;
  }

  // Get the number of wheels of the vehicle
  public int getWheel() {
    return this.wheel;
  }

  // Get the number of airbags in the vehicle
  public int getAirbags() {
    return this.airbags;
  }

  // Private constructor for Vehicle that takes a VehicleBuilder as a parameter
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Create a static nested class called VehicleBuilder
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Constructor for VehicleBuilder that takes engine and wheel as parameters
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Method to set the number of airbags in the vehicle and return the builder
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Build the Vehicle using the current state of the builder
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

// Create a public class called BuilderPattern
public class BuilderPattern {
  public static void main(String[] args) {
    // Create a car using the VehicleBuilder, specifying engine, wheel, and airbags
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    // Create a bike using the VehicleBuilder, specifying engine and wheel
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Print the engine, wheel, and airbags of the car
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    // Print the engine, wheel, and airbags of the bike
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
