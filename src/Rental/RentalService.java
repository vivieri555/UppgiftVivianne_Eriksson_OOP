package Rental;
import MemberPackage.Member;
import MemberPackage.MembershipService;
import Vehicle.Vehicle;
import java.util.ArrayList;
import Vehicle.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RentalService implements PricePolicy{
    Inventory inventory;
    MembershipService membershipService;
    public RentalService(){}
    public RentalService(Inventory inventory){
        this.inventory = inventory;
    }
    public RentalService(MembershipService membershipService){this.membershipService = membershipService;}
    //lägga in rentals i listan
    public ArrayList<Rental> rentals = new ArrayList<Rental>();
    public void add(Rental rental){
        rentals.add(rental);
    }
    public void sum(){
        double sum = 0;
        for(Rental cost: rentals){
            System.out.println("Intäkter: " + cost.getCost());
            sum = sum + cost.getCost();
        } System.out.println("Summan av intäkterna: " + sum + " kr");
    }
    public Vehicle searchCar(String search) {
        for (Vehicle car : inventory.getVehicleList()) {
            if (car.getBrand().contains(search) || car.getModel().contains(search)) {
                return car;
            }
        }
        return null;
    }
    @Override
    public double cost(int days) {
        return 1000 * days;
    }
        public void listRental(){
        for (Rental rental : rentals){
            System.out.println("Uthyrningens uppgifter:");
            System.out.println(rental.member.getName() + ", bilen: " + rental.getVehicle() + ", " + rental.getRentalDays() + " dagar, Kostnad: " + rental.getCost());
            }
        }
        public void terminateRental(String name){
        for(Rental rental: rentals){
            if(rental.getMember().equals(name)){
                System.out.println("Avslutar bokning på " + rental.getMember().getName());
                delete(rental);
            }
        } System.out.println("Avslutar bokningen");
        }
    public void delete(Rental rental) {
        {
            rentals.remove(rental);
        }
    }
    @Override
    public double getDiscountedCost(Rental rental) {
        double discountedCost = 0;
        if (rental.member.getStatus().equalsIgnoreCase("Premium")) {
            System.out.println("Medlemmen kan få rabatt 100 kr på varje uthyrning");
            discountedCost = cost(rental.getRentalDays()) -100;
        }
        else{
            return cost(rental.getRentalDays());
        }
        return discountedCost;
    }
    public void available(){
        for(Vehicle vehicle: inventory.getVehicleList()){
            if(vehicle.isLoanable()){
                System.out.println(vehicle + " är tillgänglig att låna.");
            }
        }
    }
    public void BookCar () {
        Rental rental = new Rental();
        Label nameLabel = new Label("Ange namn på medlem du vill boka bil på?");
        TextField booking = new TextField();
        booking.getText();
        Member searchNamed = membershipService.searchMemberList(booking.getText());
        if (searchNamed == null) {
            nameLabel.setText("Medlemmen finns inte");
        } else {
            nameLabel.setText("Medlemmen finns " + searchNamed.getName());
        }
        rental.setMember(searchNamed);
        nameLabel.setText("Vilken bil vill du boka? Ange varumärke");
        booking.clear();
        booking.getText();

        Vehicle car1 = searchCar(booking.getText());
        if (car1 == null || !car1.isLoanable()) {
            nameLabel.setText("Fordonet är inte tillgängligt att låna just nu");
        } else {
            car1.setLoanable(false);
            rental.setVehicle(car1);
            nameLabel.setText("Hur många dagar vill du låna?");
            booking.clear();
            booking.getText();
            rental.setRentalDays(Integer.parseInt(booking.getText()));

            //Varför säger den att den vill ha en INT , men ska va double
            double amount = cost(Integer.parseInt(String.valueOf(booking.getText())));
            nameLabel.setText("Kostnaden blir " + cost(Integer.parseInt(booking.getText())) + " kr.");
            rental.setCost(amount);
            rentals.add(rental);

            double discount = getDiscountedCost(rental);
            rental.setCost(discount);
            listRental();
            nameLabel.setText("Skriv in en ändring på historiken");
            booking.clear();
            booking.getText();
            searchNamed.setHistory(booking.getText());
        }
    }
}
