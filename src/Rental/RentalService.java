package Rental;

import MemberPackage.Member;
import Vehicle.Vehicle;

import java.util.ArrayList;

public class RentalService implements PricePolicy{
    //innehålla affärslogik boka / avsluta uthyrning
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
    public double cost(int time) {
        return 1000 * time;
    }

    @Override
    public String status() {
        return "";
    }
    //Skapa metod för att skriva ut rentals listan med objekten i
        public void listRental(){
        for (Rental rental : rentals){
            System.out.println(rental.member.getName() + ", " + rental.getVehicle() + ", " + rental.getRentalDays() + ", " + rental.getCost());
            }
        }

    //Skriva ut lista
//    public Vehicle searchVehicle(String search){
//        for(Vehicle car: inventory.getVehicleList()){
//           System.out.println(car.getBrand());
//        }
//        return search.getBrand() + ", " + car.getModel() + ", " + car.isLoanable();
//    }
}
