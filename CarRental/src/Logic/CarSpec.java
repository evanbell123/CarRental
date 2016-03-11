/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author chriswalter
 */
public class CarSpec {

    private String make;
    private String model;
    private int year;
    private carSize size;
    private LinkedList<Car> cars;

    public CarSpec(String make, String model, int year, carSize size) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.size = size;
        cars = new LinkedList<>();
    }

    CarSpec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public carSize getSize() {
        return size;
    }

    public void setSize(carSize size) {
        this.size = size;
    }

    public LinkedList<Car> getCars() {
        return this.cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CarSpec)) {
            return false;
        }

        CarSpec that = (CarSpec) other;

        // Custom equality check here.
        return this.make.equals(that.make)
                && this.model.equals(that.model)
                && this.year == that.year
                && this.size.equals(that.size);
    }

}
