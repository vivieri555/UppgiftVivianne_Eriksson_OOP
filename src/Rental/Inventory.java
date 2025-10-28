package Rental;

import Vehicle.Vehicle;
import Vehicle.CityCar;

import java.util.ArrayList;
//hanteras i minnet via List, Map eller Set. Lägga upp bilarna här?
//Summera intäkter här?
//Lägga till bilar i lista
public class Inventory {
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    public Inventory(){}
    public Inventory(Vehicle vehicle){

        //this.vehicleList = vehicle;
    }

    public ArrayList<Vehicle> getVehicleList(){
        return vehicleList;
    }
    public void addVehicle(Vehicle v){
        vehicleList.add(v);
    }
}
