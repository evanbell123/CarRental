/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author ebbmf
 */
public class Customer implements Searchable {
    private final String name;
    private final String phone;
    private final String address;
    private int carsRented;
    private final LinkedList<Rental> rentals;

    
    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.carsRented = 0;
        this.rentals = new LinkedList<>();
    };

    Customer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Customer)) {
            return false;
        }

        Customer that = (Customer) other;

        // Custom equality check here.
        return this.name.equals(that.name)
                && this.phone.equals(that.phone)
                && this.address.equals(that.address);
    }

    @Override
    public boolean contains(String text) {
        boolean theName = name.trim().toUpperCase().contains(text.trim().toUpperCase());
        boolean theAddr = address.trim().toUpperCase().contains(text.trim().toUpperCase());
        boolean thePhone = phone.trim().toUpperCase().contains(text.trim().toUpperCase());
        
        return (theName || theAddr || thePhone);
    }
    
    
    @Override 
    public String toString(){
        return name;
    }
    
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LinkedList<Rental> getRentals() {
        return rentals;
    }
    
    public void rentCar(String carID, Calendar rentDate) {
        rentals.add(new Rental(carsRented, carID, rentDate));
        carsRented++;
    }
    
    public void returnCar(String carID, Calendar returnDate) {
        findRentalByCarID(carID).returnCar(returnDate);
    }
    
    public Rental findRentalByCarID(String carID) {
        for (Rental rental : rentals) {
            if (rental.getCarID().equals(carID)) {
                return rental;
            }
        }
        return new Rental();
    }
    
}
