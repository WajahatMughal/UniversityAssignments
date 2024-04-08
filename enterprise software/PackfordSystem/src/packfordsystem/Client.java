/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class Client extends User{
    private String BranchID;
    private String address;
    
    public Client() {
        
    }


    public Client(String BranchID, String address) {
        
        this.BranchID = BranchID;
        this.address = address;
    }

    public String getBranchID() {
        return BranchID;
    }

    public void setBranchID(String BranchID) {
        this.BranchID = BranchID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" + "BranchID=" + BranchID + ", address=" + address + '}';
    }
    
}
