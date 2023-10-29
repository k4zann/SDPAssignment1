public class Main {
    public static void main(String[] args) {
        ConcreteWeatherStation weatherStation = new ConcreteWeatherStation();

        Temperature display1 = new Temperature();
        Temperature display2 = new Temperature();

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.5f);
        weatherStation.setTemperature(28.3f);
    }
}