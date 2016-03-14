/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.rentStatus.RENTED;
import static Logic.rentStatus.RETURNED;
import java.util.Calendar;

/**
 *
 * @author ebbmf
 */
public class Rental {
    private final Integer id;
    private final String carID;
    private final Calendar rentDate;
    private Calendar returnDate;
    private rentStatus status;
    
    
    public Rental(int id, String carID, Calendar rentDate) {
        this.id = id;
        this.carID = carID;
        this.rentDate = rentDate;
        this.returnDate = null;
        this.status = RENTED;
    }

    Rental() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getID() {
        return id;
    }
    
    public String getCarID() {
        return carID;
    }
    
    public Calendar getRentDate() {
        return rentDate;
    }
    
    public Calendar getReturnDate() {
        return returnDate;
    }
    
    public Boolean isReturned() {
        return returnDate != null;
    }
    
    public void returnCar(Calendar returnDate) {
        this.returnDate = returnDate;
        status = RETURNED;
    }
}
