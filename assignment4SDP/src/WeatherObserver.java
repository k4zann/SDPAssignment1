interface WeatherObserver {
    void update(float temperature);
}

class Temperature implements WeatherObserver {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Temperature: " + temperature + "C");
    }
}