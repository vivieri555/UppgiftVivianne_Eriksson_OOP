package Rental;
import MemberPackage.Member;
import MemberPackage.MembershipService;
import Vehicle.Vehicle;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RentalService implements PricePolicy{
    Inventory inventory;
    MembershipService membershipService;
    public RentalService(){}
    public RentalService(Inventory inventory, MembershipService membershipService){
                this.inventory = inventory;
        this.membershipService = membershipService;
    }
    //lägga in rentals i listan
    public ArrayList<Rental> rentals = new ArrayList<Rental>();
    public void add(Rental rental){
        rentals.add(rental);
    }

    public void sum(Label sumLabel, Label sumsLabel){
        double sum = 0;
        for(Rental cost: rentals){
            sumLabel.setText("Intäkterna: " + cost.getCost());
            System.out.println("Intäkter: " + cost.getCost());
            sum = sum + cost.getCost();
        } sumsLabel.setText("Summan av intäkterna: " + sum + " kr");
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
    public int cost(int days) {
        return 1000 * days;
    }
        public void listRental(){
        for (Rental rental : rentals){
            System.out.println("Uthyrningens uppgifter:");
            System.out.println(rental.member.getName() + ", bilen: " + rental.getVehicle() + ", " + rental.getRentalDays() + " dagar, Kostnad: " + rental.getCost());
            }
        }
        public void terminateRental(String name, Label termLabel, Label terminate){
        for(Rental rental: rentals){
            if(rental.getMember().equals(name)){
                termLabel.setText("Avslutar bokning på " + rental.getMember().getName());
                System.out.println("Avslutar bokning på " + rental.getMember().getName());
                rental.getVehicle().setLoanable(true);
                delete(rental);
            }
        } terminate.setText("Avslutar bokningen");
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
    public String available(){
        String text = "";
        for(Vehicle vehicle: inventory.getVehicleList()){
            if(vehicle.isLoanable()){
                System.out.println(vehicle + " är tillgänglig att låna.");
                text = vehicle + " är tillgänglig att låna.\n";
                //available.setText(vehicle + " är tillgänglig att låna.\n");
            }
        } return text;
    }
    public void bookVehicle(Member searchedNamed, TextField booking, TextField days,
                            Label search, Label changeHistory, TextField historyText, Label saved) {
        Rental rental = new Rental();
        rental.setMember(searchedNamed);
        booking.clear();

        booking.getText();
        Vehicle car1 = searchCar(booking.getText());
        if (car1 == null || !car1.isLoanable()) {
            search.setText("Fordonet är inte tillgängligt att låna just nu");
        } else {
            car1.setLoanable(false);
            rental.setVehicle(car1);
            booking.clear();

            String day = String.valueOf((days.getText()));
            rental.setRentalDays(Integer.parseInt(day));
            int amount = cost(Integer.parseInt(days.getText()));
            search.setText("Kostnaden blir " + amount + " kr.");
            rental.setCost(amount);

            double discount = getDiscountedCost(rental);
            rental.setCost(discount);
            rentals.add(rental);

            searchedNamed.setHistory(historyText.getText());
            saved.setText("Bokning sparad");
        }
    }
}
