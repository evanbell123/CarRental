/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import GUI.Customer_GUI;
import GUI.Search_GUI;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 *
 * @author chriswalter
 */
public class Controller {
 
    private LinkedList<Car> carList = new LinkedList<>();   
// private LinkedList<Customer> customerList = new LinkedList<>();   
 
 public void addCar(Car newCar){
     carList.add(newCar);
 }
 
 public LinkedList<Car> getAllCars(){
     return carList;
 }
 
 public void populateFindCarTable(JTable findCarTable){

     DefaultTableModel model = (DefaultTableModel) findCarTable.getModel();
     for (Car theCar : carList) {
        CarSpec theCarSpec = (CarSpec) theCar;
        model.addRow(new Object[]{theCarSpec.getMake(), theCarSpec.getModel(), theCarSpec.getSize()});
     }
     
 }
 
 
 
}
