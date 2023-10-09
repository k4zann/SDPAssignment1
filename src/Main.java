// Main class to demonstrate the Factory Design Pattern
public class Main {
    public static void main(String[] args) {
        // Create instances of PC and Server using the ComputerFactory
        Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");

        // configurations
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }
}