package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Create an interface called Subject for subjects to implement
interface Subject {
    void register(Observer obj); // Register an observer
    void unregister(Observer obj); // Unregister an observer
    void notifyObservers(); // Notify all registered observers
}

// Create a class DeliveryData that implements the Subject interface
class DeliveryData implements Subject {
    private List<Observer> observers; // List of registered observers
    private String location; // Current location

    public DeliveryData() {
        this.observers = new ArrayList<>(); // Initialize the list of observers
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj); // Register an observer by adding it to the list
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj); // Unregister an observer by removing it from the list
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location); // Notify all registered observers by calling their update method
        }
    }

    public void locationChanged() {
        this.location = getLocation(); // Simulate a change in location
        notifyObservers(); // Notify registered observers about the change
    }

    public String getLocation() {
        return "YPlace"; // Simulated location information
    }
}

// Create an interface called Observer for observers to implement
interface Observer {
    void update(String location); // Update method to be called when subject's state changes
}

// Create a class Seller that implements the Observer interface
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation(); // Show the updated location
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Create a class User that implements the Observer interface
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation(); // Show the updated location
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Create a class DeliveryWarehouseCenter that implements the Observer interface
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation(); // Show the updated location
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Create a public class called ObserverPattern
public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData(); // Create a subject

        Observer obj1 = new Seller(); // Create a seller observer
        Observer obj2 = new User(); // Create a user observer
        Observer obj3 = new DeliveryWarehouseCenter(); // Create a warehouse center observer

        topic.register(obj1); // Register the seller observer
        topic.register(obj2); // Register the user observer
        topic.register(obj3); // Register the warehouse center observer

        topic.locationChanged(); // Simulate a location change and notify observers
        topic.unregister(obj3); // Unregister the warehouse center observer

        System.out.println();
        topic.locationChanged(); // Simulate another location change and notify remaining observers
    }
}
