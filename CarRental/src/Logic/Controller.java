/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author evanb
 */
public class Controller {
    
    private static Controller singleton;
    
    private LinkedList<CarSpec> carSpecs;
    private LinkedList<Customer> customerList;
    private int availableCars = 0;
    
    public static Controller instance() {
        if (singleton == null) {
            singleton = new Controller(0);
        }
        return singleton;
    }
    
    protected Controller() throws Exception {
        if (getClass().getName().equals("Controller")) {
            throw new Exception();
        }
    }

    private Controller(int i) {
        this.customerList = new LinkedList<>();
        this.carSpecs = new LinkedList<>();
    }
    
    public void addCarSpec(String make, String model, int year, carSize size) {
        carSpecs.add(new CarSpec(make, model, year, size));
    }
    
    public void addCarSpec(CarSpec carSpec) {
        carSpecs.add(carSpec);
    }
    
    public void addCar(String make, String model, int year, carSize size, int id) {
        
        findCarSpec(make, model, year, size).addCar(new Car(id));
        availableCars++;
    }
    
    /*
    Assuming carspec exits
    */
    private CarSpec findCarSpec(String make, String model, int year, carSize size) { 
        CarSpec temp = new CarSpec(make, model, year, size);
        for (CarSpec carSpec : carSpecs) {
            if (carSpec.equals(temp)) {
                return carSpec;
            }
        }
        return new CarSpec();
    }
    
    public void addCustomer(String name, String phone, String address) {
        customerList.add(new Customer(name, phone, address));
    }
    
    
    public LinkedList<Customer> getCustomers(){
        return customerList;
    }
    
    public LinkedList<Customer> searchCustomers(String text){
        LinkedList<Customer> list = new LinkedList<>();
        
        for (Customer cust : customerList){
            if (cust.contains(text)){
                list.add(cust);
            }
        }
        return list;
    }
    public LinkedList<CarSpec> searchCarSpecs(String text){
        LinkedList<CarSpec> list = new LinkedList<>();
        
        for (CarSpec spec : carSpecs){
            if (spec.contains(text)){
                list.add(spec);
            }
        }
        return list;
    }

    public Object[][] getAvailableCars() {
        //DefaultTableModel model = (DefaultTableModel) findCarTable.getModel();
        Object[][] result = new Object[availableCars][6];
        int count = 0;
        
        for (CarSpec carSpec : carSpecs) {
            for (Car car: carSpec.getCars()) {
                Object[] carArray = {false,car.getID(),carSpec.getMake(), carSpec.getModel(), carSpec.getYear(),carSpec.getSize()};
                result[count++] = carArray;
                //model.addRow(new Object[]{carSpec.getMake(), carSpec.getModel(), carSpec.getSize()});
            }
        }
        
        return result;
    }
}
