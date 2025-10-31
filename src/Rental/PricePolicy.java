package Rental;

import MemberPackage.Member;

public interface PricePolicy {

   double cost(int time);
    double getDiscountedCost(Rental rental);
}
