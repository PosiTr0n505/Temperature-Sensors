package Generators;

import java.util.Random;

public class RandomTemperatureGenerator extends TemperatureGenerator{
    @Override
    public double generate() {
        return ABSOLUTE_ZERO + Math.random() * (MAX - ABSOLUTE_ZERO);
    }
}
