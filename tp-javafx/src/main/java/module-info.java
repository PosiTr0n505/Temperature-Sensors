module org.example.tpjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens WeatherApp to javafx.fxml;
    exports WeatherApp;
}