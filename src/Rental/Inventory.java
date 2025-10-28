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
    public Inventory(ArrayList<Vehicle> vehicle){
        //this.vehicleList<Vehicle> vehicleList = vehicle;
    }

    public ArrayList<Vehicle> getVehicleList(){
        return new ArrayList<Vehicle>(vehicleList);
    }
    public void addVehicle(Vehicle v){
        vehicleList.add(v);
    }
    public void carList(){
        for(Vehicle car: vehicleList){
            System.out.println(car);
        }
    }
}
