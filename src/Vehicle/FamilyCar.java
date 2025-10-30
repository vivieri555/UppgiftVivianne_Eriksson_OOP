package Vehicle;

public class FamilyCar extends Vehicle{
    private String doors;
    private String gearbox;
    private boolean hasRearCamera;

    public FamilyCar(){}
    public FamilyCar(String brand, String model, boolean loanable, String doors, String gearbox, boolean hasRearCamera){
        super(brand, model, loanable);
        this.doors = doors;
        this.gearbox = gearbox;
        this.hasRearCamera = hasRearCamera;
    }
    public String getDoors(){
        return doors;
    }
    public void setDoors(String doors){
        this.doors = doors;
    }
    public String getGearbox(){
        return gearbox;
    }
    public void setGearbox(String gearbox){
        this.gearbox = gearbox;
    }
    public boolean isHasRearCamera(){
        return hasRearCamera;
    }
    public void setHasRearCamera(boolean hasRearCamera){
        this.hasRearCamera = hasRearCamera;
    }
    @Override
    public void start(){
        super.start();
        System.out.println("Sätt in nyckeln i nyckelhålet för att starta");
    }
}
