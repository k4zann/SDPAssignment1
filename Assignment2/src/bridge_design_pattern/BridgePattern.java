package bridge_design_pattern;

// Define an abstract class TV
abstract class TV {
    Remote remote;

    // Constructor for TV, taking a Remote as a parameter
    TV(Remote r) {
        this.remote = r;
    }

    // Abstract methods to turn the TV on and off
    abstract void on();
    abstract void off();
}

// Create a class Sony that extends TV
class Sony extends TV {
    Remote remoteType;

    // Constructor for Sony, taking a Remote as a parameter
    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the on method
    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    // Implementation of the off method
    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Create a class Philips that extends TV
class Philips extends TV {
    Remote remoteType;

    // Constructor for Philips, taking a Remote as a parameter
    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the on method
    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    // Implementation of the off method
    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Create an interface called Remote
interface Remote {
    public void on();
    public void off();
}

// Create a class OldRemote that implements the Remote interface
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// Create a class NewRemote that implements the Remote interface
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

// Create a public class BridgePattern
public class BridgePattern {
    public static void main(String[] args) {
        // Create a Sony TV with an OldRemote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Create a Sony TV with a NewRemote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Create a Philips TV with an OldRemote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Create a Philips TV with a NewRemote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
