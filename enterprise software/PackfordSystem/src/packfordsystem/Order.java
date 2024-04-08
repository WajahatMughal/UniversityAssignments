package packfordsystem;


import packfordsystem.Crate;
import packfordsystem.CratePlacement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Order {
    private Integer OrderID;
    private String type;
    private Integer quantity;
    private Crate Crate;
    private String returnDate;
    private Integer WarehouseID;
    private Boolean is_periodic;
    private String issueDate;
    private Integer Charges;
    private CratePlacement cratePlacement;

    public Order() {
    }

    public Order(Integer OrderID, String type, Integer quantity, Crate Crate, String returnDate, Integer WarehouseID, Boolean is_periodic, String issueDate, Integer Charges, CratePlacement cratePlacement) {
        this.OrderID = OrderID;
        this.type = type;
        this.quantity = quantity;
        this.Crate = Crate;
        this.returnDate = returnDate;
        this.WarehouseID = WarehouseID;
        this.is_periodic = is_periodic;
        this.issueDate = issueDate;
        this.Charges = Charges;
        this.cratePlacement = cratePlacement;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Crate getCrate() {
        return Crate;
    }

    public void setCrate(Crate Crate) {
        this.Crate = Crate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(Integer WarehouseID) {
        this.WarehouseID = WarehouseID;
    }

    public Boolean getIs_periodic() {
        return is_periodic;
    }

    public void setIs_periodic(Boolean is_periodic) {
        this.is_periodic = is_periodic;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getCharges() {
        return Charges;
    }

    public void setCharges(Integer Charges) {
        this.Charges = Charges;
    }

    public CratePlacement getCratePlacement() {
        return cratePlacement;
    }

    public void setCratePlacement(CratePlacement cratePlacement) {
        this.cratePlacement = cratePlacement;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", type=" + type + ", quantity=" + quantity + ", Crate=" + Crate + ", returnDate=" + returnDate + ", WarehouseID=" + WarehouseID + ", is_periodic=" + is_periodic + ", issueDate=" + issueDate + ", Charges=" + Charges + ", cratePlacement=" + cratePlacement + '}';
    }
    
            
    
    
    
    
}
