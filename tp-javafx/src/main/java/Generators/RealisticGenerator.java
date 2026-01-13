package Generators;

import java.util.Random;

public class RealisticGenerator extends TemperatureGenerator {
    private static final double TEMP_INTERVAL = 2.5;
    private final Random random = new Random();

    @Override
    public double generate(){
        temperature = (ABSOLUTE_ZERO + TEMP_INTERVAL) + Math.random() * (MAX - ABSOLUTE_ZERO);
        int randomInt = random.nextInt(2);

        return temperature + ((randomInt == 1) ? TEMP_INTERVAL : -TEMP_INTERVAL);
    }

}
