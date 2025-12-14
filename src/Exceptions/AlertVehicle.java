package Exceptions;

import Rental.Inventory;
import Vehicle.Car;
import Vehicle.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertVehicle {
    Label message = new Label();
    Inventory inventory;
    Button changeB = new Button("Spara ändring");
    Button save = new Button("Spara");

    public AlertVehicle(Inventory inventory) {this.inventory = inventory;}
    public void addCar(Car car, TextField brandText, TextField modelText, TextField loanableText,
                       TextField vehicleTypeText, TextField hasRearCameraText, TextField gearboxText, TableView <Vehicle> vehicleTable) {
        Stage stage = new Stage();
        stage.setTitle("lägga till bil");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(400);
        Label carL = new Label("NY BIL");
        brandText.getText();
        modelText.getText();
        loanableText.getText();
        vehicleTypeText.getText();
        hasRearCameraText.getText();
        gearboxText.getText();

        save.setOnAction(e -> { inventory.addCar(car, brandText, modelText, loanableText,
                vehicleTypeText, hasRearCameraText, gearboxText);
            vehicleTable.refresh();
            brandText.clear();
            modelText.clear();
            loanableText.clear();
            vehicleTypeText.clear();
            hasRearCameraText.clear();
            gearboxText.clear();
                stage.close();});

        VBox layout = new VBox();
        layout.setPadding(new Insets(10,10, 10,10));
        layout.setSpacing(10);
        layout.setStyle("-fx-background-color: #9400D3;");
        layout.getChildren().addAll(carL, save, brandText, modelText, loanableText,
                vehicleTypeText, hasRearCameraText, gearboxText);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public void addBike (Bike bike, TextField brandText, TextField modelText,
                         TextField loanableText, TextField gearsText, TextField basketText) {
        Stage stage = new Stage();
        stage.setTitle("lägga till cykel");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(400);
        Label bikeL = new Label("NY CYKEL");
        brandText.getText();
        modelText.getText();
        loanableText.getText();
        gearsText.getText();
        basketText.getText();

        save.setMinWidth(50);
        save.setOnAction(e -> {
            inventory.addBike(bike, brandText, modelText, loanableText,
                    gearsText, basketText);
            bikeL.setText("Cykel sparad");
            brandText.clear();
            modelText.clear();
            loanableText.clear();
            gearsText.clear();
            basketText.clear();
            stage.close();
        });
        VBox layout = new VBox();
        layout.setPadding(new Insets(10,10, 10,10));
        layout.setSpacing(10);
        layout.setStyle("-fx-background-color: #9400D3;");
        layout.getChildren().addAll(bikeL, save, brandText, modelText, loanableText,
                gearsText, basketText);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public void changeCar (Car car, TextField brandInput, TextField modelInput, TextField loanableInput,
                           TextField vehicleTypeInput, TextField hasRearCameraInput,
                           TextField gearboxInput, TableView <Vehicle> vehicleTable) {
        Stage stage2 = new Stage();
        stage2.setTitle("Ändra");
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setMinWidth(250);
        message.setText("Ändra på bil");

        brandInput.setText(car.getBrand());
        modelInput.setText(car.getModel());
        loanableInput.setText(String.valueOf(car.isLoanable()));
        vehicleTypeInput.setText(car.getVehicleType());
        hasRearCameraInput.setText(car.getHasRearCamera());
        gearboxInput.setText(car.getGearbox());


        changeB.setOnAction(e -> {
            inventory.changeCar(car, brandInput, modelInput, loanableInput, vehicleTypeInput, hasRearCameraInput, gearboxInput);
            vehicleTable.refresh();
            stage2.close(); } );
        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(10,10, 10,10));
        layout2.setSpacing(10);
        layout2.setStyle("-fx-background-color: #9400D3;");
        layout2.getChildren().addAll(message, brandInput, modelInput, loanableInput, vehicleTypeInput, hasRearCameraInput, gearboxInput, changeB);
        layout2.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(layout2);
        stage2.setScene(scene2);
        stage2.showAndWait();
    }
}
