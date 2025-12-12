package Rental;
import Vehicle.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Inventory {
    Car car = new Car();
    Bike bike = new Bike();

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
    public void input(TextField brandText, TextField modelText,
                      TextField loanableText, TextField vehicleTypeText, TextField hasRearCameraText,
                      TextField gearboxText) {
        brandText.getText();
        modelText.getText();
        loanableText.getText();
        vehicleTypeText.getText();
        hasRearCameraText.getText();
        gearboxText.getText();
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
    public void clearC(TextField brandText, TextField modelInput, TextField loanableInput,
                      TextField vehicleTypeInput, TextField hasRearCameraInput, TextField gearboxInput) {
        brandText.clear();
        modelInput.clear();
        loanableInput.clear();
        vehicleTypeInput.clear();
        hasRearCameraInput.clear();
        gearboxInput.clear();
    }
    public void clearB(TextField brandText, TextField modelInput, TextField loanableInput,
                       TextField gearsInput, TextField basketInput) {
        brandText.clear();
        modelInput.clear();
        loanableInput.clear();
        gearsInput.clear();
        basketInput.clear();
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
