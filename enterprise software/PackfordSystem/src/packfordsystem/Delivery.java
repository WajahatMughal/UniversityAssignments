/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class Delivery {
    private String address;
    private String deliveryType;
    private String dateOfDispatch;

    public Delivery() {
    }

    public Delivery(String address, String deliveryType, String dateOfDispatch) {
        this.address = address;
        this.deliveryType = deliveryType;
        this.dateOfDispatch = dateOfDispatch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDateOfDispatch() {
        return dateOfDispatch;
    }

    public void setDateOfDispatch(String dateOfDispatch) {
        this.dateOfDispatch = dateOfDispatch;
    }

    @Override
    public String toString() {
        return "Delivery{" + "address=" + address + ", deliveryType=" + deliveryType + ", dateOfDispatch=" + dateOfDispatch + '}';
    }
    
    
}
