/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class WareHouse {
     private Integer warehouseID;
   private String location;
   private String Capacity;

    public WareHouse(Integer warehouseID, String location, String Capacity) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.Capacity = Capacity;
    }

    public Integer getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }
   
    
}
