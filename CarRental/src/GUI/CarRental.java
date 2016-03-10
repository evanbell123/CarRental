/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Car;
import Logic.CarSpec;
import static Logic.carSize.*;
import java.awt.Dimension;
import java.util.LinkedList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evanb
 */
public class CarRental {

    private final LinkedList<CarSpec> carSpecs;

    public CarRental() {
        this.carSpecs = new LinkedList<>();

        /*
        Generate sample carSpecs
         */
        carSpecs.add(new CarSpec("Nissan", "Altima", 2012, SMALL));
        carSpecs.add(new CarSpec("Nissan", "Altima", 2012, MIDSIZED));
        carSpecs.add(new CarSpec("Volks Wagen", "Passat", 2002, LARGE));
        carSpecs.add(new CarSpec("Mercedes", "Benz", 2000, SMALL));

        /*
        Generate sample cars for each carSpec
         */
        int id = 0; // this is the starting id
        int carsPerSpec = 3; // Generate 3 cars for each spec

        for (CarSpec carSpec : carSpecs) {
            for (int i = 0; i < carsPerSpec; i++) {
                carSpec.addCar(new Car(id));
                id++;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try 
            { 
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            } 
            catch(Exception e){ 
            }
        CarRental controller = new CarRental();

//      Starting GUI      
        Search_GUI frame;
        frame = new Search_GUI(controller);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(250, 250);
        frame.setSize(700, 500);
        frame.setMaximumSize(new Dimension(800, 400));
        frame.setVisible(true);
    }

    void populateFindCarTable(JTable findCarTable) {
        DefaultTableModel model = (DefaultTableModel) findCarTable.getModel();
        for (CarSpec carSpec : carSpecs) {
            for (Car car: carSpec.getCars()) {
                model.addRow(new Object[]{carSpec.getMake(), carSpec.getModel(), carSpec.getSize()});
            }
            
        }
    }

}
