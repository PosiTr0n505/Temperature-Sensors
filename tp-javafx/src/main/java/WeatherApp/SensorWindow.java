package WeatherApp;

import Models.Observer;
import Models.Sensor;
import javafx.application.Application;
import javafx.stage.Stage;

public class SensorWindow extends Application implements Observer {


    public static void main(String[] args) {
        launch(args);
    }
    public void update(double newTempareture){

    }

    @Override
    public void start(Stage primaryStage) {

    }
}
