package Models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VirtualSensor extends Sensor {
    private Map<Sensor, Double> subSensors = new HashMap<>();

    private Map<Sensor, Observer> subSensorObservers = new HashMap<>();

    public VirtualSensor(String name) {
        super(name);
    }

    public void addSensor(Sensor s, double weight) {
        subSensors.put(s, weight);
        Observer obs = newTemp -> calculateWeightedAverage();
        s.attach(obs);
        calculateWeightedAverage();
    }

    public Map<Sensor, Double> getSubSensors() {
        return subSensors;
    }

    public void removeSensor(Sensor s) {
        if (subSensors.containsKey(s)) {
            subSensors.remove(s);

            Observer obs = subSensorObservers.remove(s);
            if (obs != null) {
                s.detach(obs);
            }
            calculateWeightedAverage();
        }
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
