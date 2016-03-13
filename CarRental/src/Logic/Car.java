/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.carStatus.AVAILABLE;

/**
 *
 * @author EVAN & ALDO
 */
public class Car {

    private String ID;
    private CarSpec carSpec;
    private carStatus status;

    public Car(String ID, CarSpec carSpec) {
        this.ID = ID;
        this.carSpec = carSpec;
        this.status = AVAILABLE;
    }

    Car() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public carStatus getStatus() {
        return status;
    }
    
    public void setStatus(carStatus status) {
        this.status = status;
    }
    
    public String getMake() {
        return carSpec.getMake();
    }
    
    public String getModel() {
        return carSpec.getModel();
    }
    
    public int getYear() {
        return carSpec.getYear();
    }
    
    public CarSize getSize() {
        return carSpec.getSize();
    }
}
