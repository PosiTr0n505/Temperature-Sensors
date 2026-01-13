module org.example.tpjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens WeatherApp to javafx.fxml;
    opens WeatherApp.Controller to javafx.fxml;
    exports WeatherApp;
    exports Models;
    exports Generators;
}