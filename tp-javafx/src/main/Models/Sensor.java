package Models;

import java.util.UUID;

public class Sensor extends Observable {

    private final UUID id;
    private String name;
    private double temperature;


    public Sensor(UUID id, String name, double temperature) {
        this.id=id;
        this.name=name;
        this.temperature=temperature;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            notifyChanges(this.temperature);
        }
    }
}
