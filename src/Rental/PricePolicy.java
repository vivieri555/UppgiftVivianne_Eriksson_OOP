package Rental;

import MemberPackage.Member;

public interface PricePolicy {
    //Lägga till 2 implementationer
    //(interface) + konkreta strategier, ex. standard, student, premium
    //pris per dag
   double cost(int time);
    String status();
}
