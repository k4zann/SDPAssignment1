package singleton_design_pattern;

// Create a SingletonEagar class using eager initialization
class SingletonEagar {
  private static SingletonEagar instance = new SingletonEagar(); // Initialize the instance eagerly

  private SingletonEagar() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonEagar getInstance() {
    return instance; // Return the pre-initialized instance
  }
}

// Create a Singleton class using lazy initialization
class Singleton {
  private static Singleton instance; // Initialize the instance lazily

  private Singleton() {
    // Private constructor to prevent external instantiation
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton(); // Create a new instance only if it doesn't exist
    }
    return instance;
  }
}

// Create a SingletonSynchronizedMethod class using lazy initialization with synchronization
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance; // Initialize the instance lazily

  private SingletonSynchronizedMethod() {
    // Private constructor to prevent external instantiation
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod(); // Create a new instance only if it doesn't exist
    }
    return instance;
  }
}

// Create a SingletonSynchronized class using lazy initialization with synchronized block
class SingletonSynchronized {
  private static SingletonSynchronized instance; // Initialize the instance lazily

  private SingletonSynchronized() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized(); // Create a new instance only if it doesn't exist
        }
      }
    }
    return instance;
  }
}

// Create a public class called SingletonPattern for testing the singletons
public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
