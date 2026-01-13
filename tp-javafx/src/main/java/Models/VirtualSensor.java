package Models;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VirtualSensor extends Sensor {
    private Map<Sensor, Double> subSensors = new HashMap<>();

    public VirtualSensor(String name) {
        super(name);
    }

    public void addSensor(Sensor s, double weight) {
        if (s == this) return;

        subSensors.put(s, weight);
        s.attach(newTemp -> calculateWeightedAverage());

        calculateWeightedAverage();
    }

    public Map<Sensor, Double> getSubSensors() {
        return subSensors;
    }

    private void calculateWeightedAverage() {
        double totalTemp = 0;
        double totalWeight = 0;

        for (Map.Entry<Sensor, Double> entry : subSensors.entrySet()) {
            totalTemp += entry.getKey().getTemperature() * entry.getValue();
            totalWeight += entry.getValue();
        }

        if (totalWeight == 0) {
            this.setTemperature(0.0);
        } else {
            this.setTemperature(totalTemp / totalWeight);
        }
    }
}
