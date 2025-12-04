package Vehicle;

public class CityCar extends Vehicle{
    private String color;
    private String doors;

    public CityCar(String brand, String model, boolean loanable, String color, String doors){
        super(brand, model, loanable);
        this.color = color;
        this.doors = doors;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getDoors(){
        return doors;
    }
    public void setDoors(String doors){
        this.doors = doors;
    }
    @Override
    public void start(){
        super.start();
        System.out.println("Tryck på knappen för att starta");
    }
}
