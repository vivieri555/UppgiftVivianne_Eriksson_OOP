package Rental;

import MemberPackage.Member;
import Vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Rental{
    //(kopplar member och item för en viss tidsperiod)
    //Map för att koppla member. item?
    Member member;
    Vehicle vehicle;
    private int rentalDays;
    private double cost;
    public Rental(){}
    public Rental(Member member, Vehicle vehicle, int rentalDays, double cost){
        this.member = member;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.cost = cost;
    }
    public int getRentalDays(){
        return rentalDays;
    }
    public void setRentalDays(int rentalDays){
        this.rentalDays = rentalDays;
    }
    public double getCost(){
        return cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public Member getMember(){
        return member;
    }
    public void setMember(Member member){
        this.member = member;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public LocalDate loanDays(int days){
        return LocalDate.now().plusDays(days);
    }
}
