// Abstract class Computer
public abstract class Computer {

    // Abstract methods to get RAM, HDD, and CPU details
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    // Override toString method to display computer configuration
    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}