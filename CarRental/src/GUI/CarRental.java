/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.CarSpec;
import Logic.Controller;
import static Logic.CarSize.*;
import java.awt.Dimension;
import java.util.LinkedList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author evanb
 */
public class CarRental {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        Controller controller = Controller.instance();
        
        /*
        Generate sample carSpecs
         */
        CarSpec Altima2012 = new CarSpec("Nissan", "Altima", 2012, SMALL);
        CarSpec Maxima2015 = new CarSpec("Nissan", "Maxima", 2015, MIDSIZED);
        CarSpec Titan2016 = new CarSpec("Nissan", "Titan", 2016, LARGE);
       
        controller.addCarSpec(Altima2012);
        controller.addCarSpec(Maxima2015);
        controller.addCarSpec(Titan2016);
        
        /*
        Generate sample cars for each carSpec
         */
        controller.addCar(Altima2012, "1");
        controller.addCar(Maxima2015, "2");
        controller.addCar(Maxima2015, "3");
        controller.addCar(Titan2016, "4");
        
        /*
        Generate Sample Customers
         */
        controller.addCustomer("Chris Walter", "456-641-1235", "300UMKC");
        controller.addCustomer("Evan Bell", "556-641-1236", "400UMKC");
        controller.addCustomer("Aldo II", "981-641-1239", "500UMKC");
        
//      Starting GUI      
        Search_GUI frame;
        frame = new Search_GUI(controller);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(250, 250);
        frame.setSize(700, 500);
        frame.setMaximumSize(new Dimension(800, 400));
        frame.setVisible(true);
    }
}
