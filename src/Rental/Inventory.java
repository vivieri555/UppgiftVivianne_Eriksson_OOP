package Rental;
import MemberPackage.Member;
import Vehicle.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

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
}
