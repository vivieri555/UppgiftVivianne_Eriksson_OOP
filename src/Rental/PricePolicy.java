package Rental;

import javafx.scene.control.Label;

public interface PricePolicy {

   int cost(int time);
    double getDiscountedCost(Rental rental, Label discountLabel);
}
