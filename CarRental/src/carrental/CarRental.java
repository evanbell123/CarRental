/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import GUI.Search_GUI;
import Logic.Car;
import Logic.CarSpec;
import Logic.Controller;
import Logic.carSize;
import java.awt.Dimension;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author evanb
 */
public class CarRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        CarSpec car1 = new CarSpec(1,"Ford", "Fusion", 2014, carSize.MIDSIZED);
        CarSpec car2 = new CarSpec(2,"Ford", "Escape", 2001, carSize.LARGE);
        CarSpec car3 = new CarSpec(3,"Chevrolet", "Corvette", 2016, carSize.SMALL);

//      Adding Cars 
        controller.addCar((Car)car1);
        controller.addCar((Car)car2);
        controller.addCar((Car)car3);

//      Starting GUI      
        Search_GUI frame=new Search_GUI(controller);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(250, 250);
        frame.setSize(700,500);
        frame.setMaximumSize(new Dimension(800, 400));
        frame.setVisible(true);
    }
    
}
