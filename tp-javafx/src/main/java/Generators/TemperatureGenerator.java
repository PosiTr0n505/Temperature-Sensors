package Generators;

public abstract class TemperatureGenerator {

    protected final double ABSOLUTE_ZERO = -273.15;
    protected final double MAX = 5000;
    protected double temperature;

    public double generate(){
        return temperature;
    }
}
