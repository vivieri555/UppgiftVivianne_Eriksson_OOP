package Rental;
import Vehicle.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    public Inventory(){}
    public Inventory(ObservableList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public ObservableList<Vehicle> getVehicleList(){
        return vehicleList;
    }
    public void addVehicle(Vehicle v){
        vehicleList.add(v);
    }
    public void remove(Vehicle v) { vehicleList.remove(v); }
    public void filterV (TableView<Vehicle> vehicleTable) {
//        vehicleTable.getColumns().clear();
//        ObservableList<Vehicle> bikes = (ObservableList<Vehicle>) vehicleList.stream().filter(b -> b instanceof Bike).collect(Collectors.toList());
//        vehicleTable.setItems(bikes);
        FilteredList<Vehicle> bike = new FilteredList<>(vehicleList, p -> true);
        bike.setPredicate(vehicle -> vehicle.getBrand().toLowerCase().contains(vehicle.getBrand().toLowerCase()));
        vehicleTable.setItems(bike);
    }
    public void unFilterV(TableView<Vehicle> vehicleTable, Label label) {
        for (Vehicle v : vehicleTable.getItems()) {
            if (v instanceof Bike){
                System.out.println(v);
            }
        }
    }
    public void addCar (Car car, TextField brandText, TextField modelText,
                      TextField loanableText, TextField vehicleTypeText, TextField hasRearCameraText,
                      TextField gearboxText) {
        car.setBrand(brandText.getText());
        car.setModel(modelText.getText());
        car.setLoanable(Boolean.parseBoolean(loanableText.getText()));
        car.setVehicleType(vehicleTypeText.getText());
        car.setHasRearCamera(hasRearCameraText.getText());
        car.setGearbox(gearboxText.getText());
        vehicleList.add(car);
    }
    public void addBike (Bike bike, TextField brandText, TextField modelText,
                         TextField loanableText, TextField gearsText, TextField basketText) {
        bike.setBrand(brandText.getText());
        bike.setModel(modelText.getText());
        bike.setLoanable(Boolean.parseBoolean(loanableText.getText()));
        bike.setGears(gearsText.getText());
        bike.setBasket(basketText.getText());
        vehicleList.add(bike);
    }
    public void changeCar (Car car, TextField brandInput, TextField modelInput, TextField loanableInput,
                           TextField vehicleTypeInput, TextField hasRearCameraInput, TextField gearboxInput) {
        car.setBrand(brandInput.getText());
        car.setModel(modelInput.getText());
        car.setLoanable(Boolean.parseBoolean(loanableInput.getText()));
        car.setVehicleType(vehicleTypeInput.getText());
        car.setHasRearCamera(hasRearCameraInput.getText());
        car.setGearbox(gearboxInput.getText());
    }
}
