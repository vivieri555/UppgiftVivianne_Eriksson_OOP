package Vehicle;

public class ElectricCar extends Vehicle{

    private String doors;
    private String batteryLevel;


    public ElectricCar(){}
    public ElectricCar(String brand, String model, String doors, String batteryLevel){
        super(brand, model);
        this.doors = doors;
        this.batteryLevel = batteryLevel;

    }

    public String getDoors(){
        return doors;
    }
    public void setDoors(String doors){
        this.doors = doors;
    }
    public String getBatteryLevel(){
        return batteryLevel;
    }
    public void setBatteryLevel(String batteryLevel){
        this.batteryLevel = batteryLevel;
    }

}
