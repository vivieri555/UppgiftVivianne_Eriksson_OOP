package Rental;

import MemberPackage.Member;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalService implements PricePolicy{
    //innehålla affärslogik boka / avsluta uthyrning
    Scanner input = new Scanner(System.in);
    Inventory inventory;
    public RentalService(){}
    public RentalService(Inventory inventory){
        this.inventory = inventory;
    }
    //lägga in rentals i listan
    public ArrayList<Rental> rentals = new ArrayList<Rental>();
    public void add(Rental rental){
        rentals.add(rental);
    }
            //Söka upp car Brand, hur skriver jag ut alla attribut på den bilen jag hittat?
    public Vehicle searchBrand(String search) {
        for (Vehicle car : inventory.getVehicleList()) {
            if (car.getBrand().contains(search)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public double cost(int days) {
        return 1000 * days;
    }
    //Skapa metod för att skriva ut rentals listan med objekten i
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
        return discountedCost;
    }
}
