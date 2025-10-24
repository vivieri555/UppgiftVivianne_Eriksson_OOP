package Vehicle;

import java.util.ArrayList;

public class Vehicle extends Item{
    private String brand;
    private String model;

    public Vehicle(){}
    public Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
    //Göra implementering/override i andra klasserna, start med knapp, vrida knapp
    public void start(){
    }
    private ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
    //add vehicles vehicle.add(new ElectricCar("5", "95"));
    public void addVehicle(Vehicle v){
        vehicle.add(v);
    }
}
