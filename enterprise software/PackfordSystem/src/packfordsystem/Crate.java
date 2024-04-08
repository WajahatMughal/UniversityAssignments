/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class Crate {
    private Integer crateID;
    private String stauts;
    private String type;
    private Integer price;
    private String space ;

    public Integer getCrateID() {
        return crateID;
    }

    public void setCrateID(Integer crateID) {
        this.crateID = crateID;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public Crate(Integer crateID, String stauts, String type, Integer price, String space) {
        this.crateID = crateID;
        this.stauts = stauts;
        this.type = type;
        this.price = price;
        this.space = space;
    }

    public Crate() {
    }

    @Override
    public String toString() {
        return "Crate{" + "crateID=" + crateID + ", stauts=" + stauts + ", type=" + type + ", price=" + price + ", space=" + space + '}';
    }
    
}
