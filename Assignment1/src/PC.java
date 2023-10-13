// Concrete class representing a PC computer
public class PC extends Computer {
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor to initialize PC properties
    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    // Implement abstract methods to get PC config
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