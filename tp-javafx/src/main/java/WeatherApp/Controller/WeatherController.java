package WeatherApp.Controller;

import Generators.RealisticGenerator;
import Generators.TemperatureGenerator;
import Models.Sensor;
import Models.VirtualSensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.Map;

public class WeatherController {
    @FXML
    private ListView<Sensor> sensorListView;
    @FXML
    private VBox detailsPane;
    private ObservableList<Sensor> allSensors = FXCollections.observableArrayList();

    private void showSensorDetails(Sensor sensor) {
        detailsPane.getChildren().clear();
        if (sensor == null) return;

        Label nameLabel = new Label("Name: " + sensor.getName());
        Label idLabel = new Label("ID: " + sensor.getId().toString());
        Label tempLabel = new Label();

        tempLabel.textProperty().bind(sensor.temperatureProperty().asString("Temp: %.2f °C"));

        detailsPane.getChildren().addAll(nameLabel, idLabel, tempLabel);
    }

    private void showVirtualSensorDetails(VirtualSensor vs) {
        detailsPane.getChildren().clear();

        Label nameLabel = new Label("Name: " + vs.getName());
        Label typeLabel = new Label("Type: Virtual Sensor (Average)");
        Label tempLabel = new Label();
        tempLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: blue;");
        tempLabel.textProperty().bind(vs.temperatureProperty().asString("%.2f °C"));

        ListView<String> contributors = new ListView<>();
        contributors.setPrefHeight(150);
        updateContributorList(vs, contributors);

        Button addSourceBtn = new Button("Add Source Sensor");
        addSourceBtn.setOnAction(e -> {
            addSourceToVirtual(vs, contributors);
        });

        detailsPane.getChildren().addAll(nameLabel, typeLabel, tempLabel, new Label("Contributors:"), contributors, addSourceBtn);
    }

    private void updateContributorList(VirtualSensor vs, ListView<String> view) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Map.Entry<Sensor, Double> entry : vs.getSubSensors().entrySet()) {
            items.add(entry.getKey().getName() + " (Weight: " + entry.getValue() + ")");
        }
        view.setItems(items);
    }

    public void initialize(){
        sensorListView.setItems(allSensors);

        // Custom Cell to show Name
        sensorListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Sensor item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getName());
            }
        });

        sensorListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal instanceof VirtualSensor) {
                showVirtualSensorDetails((VirtualSensor) newVal);
            } else {
                showSensorDetails(newVal);
            }
        });
    }

    @FXML
    public void onCreateSensor() {
        TextInputDialog nameDialog = new TextInputDialog("Sensor");
        nameDialog.setTitle("New Sensor");
        nameDialog.setHeaderText("Step 1: Name your sensor");
        nameDialog.setContentText("Name:");

        nameDialog.showAndWait().ifPresent(name -> {
            ObservableList<String> options = FXCollections.observableArrayList("Realistic", "Random");
            ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Realistic", options);
            choiceDialog.setTitle("Generator Selection");
            choiceDialog.setHeaderText("Step 2: Choose behavior");
            choiceDialog.setContentText("Type:");

            choiceDialog.showAndWait().ifPresent(choice -> {
                TemperatureGenerator gen;
                if (choice.equals("Random")) {
                    gen = new Generators.RandomTemperatureGenerator();
                } else {
                    gen = new Generators.RealisticGenerator();
                }

                Sensor newSensor = new Sensor(name, gen);
                allSensors.add(newSensor);
                newSensor.start();
            });
        });
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void onCreateVirtualSensor() {
        TextInputDialog dialog = new TextInputDialog("Virtual Sensor");
        dialog.setTitle("New Virtual Sensor");
        dialog.setHeaderText("Create a Virtual Sensor");
        dialog.setContentText("Name:");

        dialog.showAndWait().ifPresent(name -> {
            if (name.trim().isEmpty()) {
                showError("Name cannot be empty");
                return;
            }
            VirtualSensor vs = new VirtualSensor(name);
            allSensors.add(vs);
        });
    }

    private void addSourceToVirtual(VirtualSensor vs, ListView<String> viewToUpdate) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Add Source");
        dialog.setHeaderText("Pick a sensor and a weight");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        ComboBox<Sensor> sensorBox = new ComboBox<>(allSensors.filtered(s -> s != vs));
        TextField weightField = new TextField("1.0");
        VBox content = new VBox(10, new Label("Sensor:"), sensorBox, new Label("Weight:"), weightField);
        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK && sensorBox.getValue() != null) {
                try {
                    double w = Double.parseDouble(weightField.getText());
                    vs.addSensor(sensorBox.getValue(), w);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        });

        dialog.showAndWait().ifPresent(success -> {
            if (success) updateContributorList(vs, viewToUpdate);
        });
    }

    @FXML
    public void onDeleteSensor() {
        Sensor selected = sensorListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("No sensor selected");
            return;
        }

        // Confirm deletion
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Delete Sensor");
        confirm.setHeaderText("Delete " + selected.getName() + "?");
        confirm.setContentText("This action cannot be undone.");

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                selected.stop(); // Stop the thread
                allSensors.remove(selected);
                detailsPane.getChildren().clear(); // Clear details view
            }
        });
    }

    public void shutdown() {
        for (Sensor s : allSensors) {
            s.stop();
        }
    }
}


