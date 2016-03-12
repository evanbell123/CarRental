/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.CarSpec;
import Logic.Controller;
import static Logic.carSize.*;
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

    //private static LinkedList<CarSpec> sampleCarSpecs;
    //private static int id = 0; // this is the starting id
    //private static final int carsPerSpec = 3; // Generate 3 cars for each spec

    public CarRental() {
        /*
        sampleCarSpecs = new LinkedList<>();
        sampleCarSpecs.add(new CarSpec("Nissan", "Altima", 2012, SMALL));
        sampleCarSpecs.add(new CarSpec("Nissan", "Altima", 2012, MIDSIZED));
        sampleCarSpecs.add(new CarSpec("Volks Wagen", "Passat", 2002, LARGE));
        sampleCarSpecs.add(new CarSpec("Mercedes", "Benz", 2000, SMALL));
        */
    }

    /**
     * @param args the command line arguments
     */
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
        controller.addCar("Nissan", "Altima", 2012, SMALL, 1);
        controller.addCar("Nissan", "Altima", 2012, SMALL, 2);
        controller.addCar("Nissan", "Maxima", 2015, MIDSIZED, 3);
        controller.addCar("Nissan", "Titan", 2016, LARGE, 4);

                
        /*
        sampleCarSpecs.stream().forEach((CarSpec carSpec) -> {
            for (int i = 0; i < carsPerSpec; i++) {
                controller.addCar(carSpec, id);
                id++;
            }
        });
*/
        
        

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
