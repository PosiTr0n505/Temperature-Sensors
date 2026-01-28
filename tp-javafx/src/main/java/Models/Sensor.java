package Models;

import Generators.RealisticGenerator;
import Generators.TemperatureGenerator;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import java.util.Comparator;
import java.util.UUID;

public class Sensor extends Observable implements Runnable {

    private final UUID id = UUID.randomUUID();
    private final StringProperty name = new SimpleStringProperty();
    private DoubleProperty temperature = new SimpleDoubleProperty();
    private Thread thread;
    private TemperatureGenerator generator;

    private volatile boolean running = false;

    public Sensor(String name, TemperatureGenerator generator) {
        this.name.set(name);
        this.generator = generator;
        if (generator != null) {
            this.temperature.set(generator.generate());
        }
    }

    protected Sensor(String name) {
        this.name.set(name);
        this.generator = null;
        this.temperature.set(0.0);
    }

    public TemperatureGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(TemperatureGenerator generator) {
        this.generator = generator;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    @FXML
    public StringProperty nameProprety(){
        return name;
    }

    public void setName(String name){
        this.name.set(name);
    }

    public double getTemperature() { return temperature.get(); }

    @FXML
    public DoubleProperty temperatureProperty() { return temperature; }

    public void setTemperature(double temperature) {
        if (this.temperature.getValue() != temperature) {
            this.temperature.setValue(temperature);
        }
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                if (generator != null) {
                    double newTemp = generator.generate();
                    Platform.runLater(() -> setTemperature(newTemp));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void start() {
        if (generator == null) return;

        if (thread == null || !thread.isAlive()) {
            running = true;
            thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
        }
    }

    public void stop() {
        running = false;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
