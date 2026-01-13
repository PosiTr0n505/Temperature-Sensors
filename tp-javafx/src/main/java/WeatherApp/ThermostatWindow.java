package WeatherApp;

import javafx.scene.control.Spinner;

public class ThermostatWindow extends SensorWindow {

    private Spinner spinner;

    public ThermostatWindow() {
        spinner = new Spinner<>(-273, 500, 20);
    }

    public void update(double temperature){

    }
}
