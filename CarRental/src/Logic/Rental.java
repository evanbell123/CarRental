/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Calendar;

/**
 *
 * @author ebbmf
 */
public class Rental {
    private final Calendar rentDate;
    private final Calendar returnDate;
    private final rentStatus status;
    private final Car car;
    private final Customer customer;
    
    public Rental(Calendar rentDate, Calendar returnDate, rentStatus status, Car car, Customer customer) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.status = status;
        this.car = car;
        this.customer = customer;
    }
}
