/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author EVAN & ALDO
 */
public class Car {

    private int ID;
    private CarSpec carSpec;
    private LinkedList<Rental> rentals;

    public Car(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
