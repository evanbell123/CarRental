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
public class Customer {
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
}
