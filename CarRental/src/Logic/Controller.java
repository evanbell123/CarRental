/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.carStatus.AVAILABLE;
import static Logic.carStatus.UNAVAILABLE;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author evanb
 */
public class Controller {

    private static Controller singleton;

    private LinkedList<CarSpec> carSpecs;
    private LinkedList<Car> cars;
    private LinkedList<Customer> customerList;
    private int availableCars = 0;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

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
        this.cars = new LinkedList<>();
    }

    public void addCarSpec(String make, String model, int year, CarSize size) {
        carSpecs.add(new CarSpec(make, model, year, size));
    }

    public void addCarSpec(CarSpec carSpec) {
        carSpecs.add(carSpec);
    }

    public void addCar(CarSpec carSpec, String id) {

        /*
         Double check that the car spec exists
         */
        CarSpec spec = findCarSpec(carSpec.getMake(), carSpec.getModel(), carSpec.getYear(), carSpec.getSize());
        cars.add(new Car(id, spec));
        availableCars++;
    }

    public void addCustomer(String name, String phone, String address) {
        customerList.add(new Customer(name, phone, address));
    }

    public LinkedList<Customer> getCustomers() {
        return customerList;
    }

    /*
     Get customer that matches accountName, phoneNumber and address
     */
    public Customer getCustomer(String accountName, String phone, String address) {
        Customer temp = new Customer(accountName, phone, address);
        for (Customer customer : customerList) {
            if (customer.equals(temp)) {
                return customer;
            }
        }
        return new Customer();
    }

    public void rentCar(String accountName, String phone, String address, String carID, String rentDate) {

        String[] dateTokens = rentDate.split("/");

        int month = Integer.parseInt(dateTokens[0]);
        int day = Integer.parseInt(dateTokens[1]);
        int year = Integer.parseInt(dateTokens[2]);

        Calendar rentDateCal = new GregorianCalendar(year, month, day);

        Customer customer = getCustomer(accountName, phone, address);

        customer.rentCar(carID, rentDateCal);

        getCarByID(carID).setStatus(UNAVAILABLE);
        availableCars--;

    }

    public void returnCar(String accountName, String phone, String address, Integer rentalID, String returnDate) {

        String[] dateTokens = returnDate.split("/");

        int month = Integer.parseInt(dateTokens[0]);
        int day = Integer.parseInt(dateTokens[1]);
        int year = Integer.parseInt(dateTokens[2]);

        Calendar returnDateCal = new GregorianCalendar(year, month, day);

        Customer customer = getCustomer(accountName, phone, address);

        String carID = getRentalCarID(customer, rentalID);

        customer.returnCar(rentalID, returnDateCal);

        //customer.returnCar(carID, returnDateCal);
        getCarByID(carID).setStatus(AVAILABLE);
        availableCars++;

    }

    public LinkedList<Customer> searchCustomers(String text) {
        LinkedList<Customer> list = new LinkedList<>();

        for (Customer cust : customerList) {
            if (cust.contains(text)) {
                list.add(cust);
            }
        }
        return list;
    }

    public Object[][] getAvailableCars() {
        Object[][] result = new Object[availableCars][6];
        int count = 0;

        for (Car car : cars) {
            if (car.getStatus().equals(AVAILABLE)) {
                Object[] carArray = {false, car.getID(), car.getMake(), car.getModel(), car.getYear(), car.getSize()};
                result[count++] = carArray;
            }
        }

        return result;
    }

    public Object[][] getRentedCars(String accountName, String phone, String address) {

        Customer customer = getCustomer(accountName, phone, address);
        LinkedList<Rental> rentals = customer.getRentals();

        Object[][] result = new Object[customer.getCarsRented()][5];
        int count = 0;

        for (Rental rental : rentals) {
            if (!rental.isReturned()) {
                Car car = getCarByID(rental.getCarID());
                
                String rentalDate = dateFormat.format(rental.getRentDate().getTime());
                
                Object[] carArray = {false, rental.getID(), car.getMake(), car.getModel(), car.getYear(), rentalDate};
                result[count++] = carArray;
            }
        }

        return result;
    }
    
    public Object[][] getReturnedCars(String accountName, String phone, String address) {

        Customer customer = getCustomer(accountName, phone, address);
        LinkedList<Rental> rentals = customer.getRentals();

        Object[][] result = new Object[customer.getCarsReturned()][5];
        int count = 0;

        for (Rental rental : rentals) {
            if (rental.isReturned()) {
                Car car = getCarByID(rental.getCarID());
                
                String rentalDate = dateFormat.format(rental.getRentDate().getTime());
                String returnDate = dateFormat.format(rental.getReturnDate().getTime());
                
                Object[] carArray = {rental.getID(), car.getMake(), car.getModel(), car.getYear(), rentalDate, returnDate};
                result[count++] = carArray;
            }
        }

        return result;
    }
    
    /*
     Assuming carspec exits
     */

    private CarSpec findCarSpec(String make, String model, int year, CarSize size) {
        CarSpec temp = new CarSpec(make, model, year, size);
        for (CarSpec carSpec : carSpecs) {
            if (carSpec.equals(temp)) {
                return carSpec;
            }
        }
        return new CarSpec();
    }

    private Car getCarByID(String carID) {
        for (Car car : cars) {
            if (car.getID().equals(carID)) {
                return car;
            }
        }
        return new Car();
    }

    private String getRentalCarID(Customer customer, int rentalID) {
        for (Rental rental : customer.getRentals()) {
            if (rental.getID() == rentalID) {
                return rental.getCarID();
            }
        }

        return "";
    }
}
