/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author ebbmf
 */
public class Customer implements Searchable {
    private final String name;
    private final String phone;
    private final String address;
    private final LinkedList<Rental> rentals;

    
    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rentals = new LinkedList<>();
    };

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
    
}
