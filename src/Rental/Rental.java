package Rental;

import java.time.LocalDateTime;

public class Rental {
    //(kopplar member och item för en viss tidsperiod)
    public LocalDateTime rentalTime(long rentalTime){
        return LocalDateTime.now().plusDays(rentalTime);
    }

}
