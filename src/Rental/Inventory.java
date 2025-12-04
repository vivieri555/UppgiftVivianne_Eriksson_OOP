package Rental;
import Vehicle.Vehicle;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    public Inventory(){}

    public ArrayList<Vehicle> getVehicleList(){
        return vehicleList;
    }
    public void addVehicle(Vehicle v){
        vehicleList.add(v);
    }
}
