package WeatherApp;

import javafx.application.Application;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class ThermostatWindow extends SensorWindow {

    private Spinner spinner;

    public ThermostatWindow() {
        spinner = new Spinner<>(-273, 500, 20);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void update(double temperature){

    }
    @Override
    public void start(Stage primaryStage) {

    }
}
