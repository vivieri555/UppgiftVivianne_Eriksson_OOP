package Rental;

public interface PricePolicy {

   int cost(int time);
    double getDiscountedCost(Rental rental);
}
