// Concrete class representing a Server computer
public class Server extends Computer {
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor to initialize Server properties
    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    // Implement abstract methods to get Server config
    @Override
    public String getRAM() {
        return this.ram;
    }
    @Override
    public String getHDD() {
        return this.hdd;
    }
    @Override
    public String getCPU() {
        return this.cpu;
    }
}