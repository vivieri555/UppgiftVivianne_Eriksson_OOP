package Vehicle;

import javafx.scene.control.TextField;

public class Bike extends Vehicle{
    private String gears;
    private String basket;
    public Bike() {}
    public Bike (String brand, String model, Boolean loanable, String gears, String basket) {
        super(brand, model, loanable);
        this.gears = gears;
        this.basket = basket;
    }
    public String getGears() {
        return gears;
    }
    public void setGears(String gears) {
        this.gears = gears;
    }
    public String getBasket () {
        return basket;
    }
    public void setBasket(String basket) {
        this.basket = basket;
    }
    @Override
    public void start() {
        super.start();
        TextField startText = new TextField();
        startText.setText("Trampa med fötterna för att rulla");
    }
}
