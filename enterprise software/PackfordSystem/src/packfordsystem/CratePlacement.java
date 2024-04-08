/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class CratePlacement {
    private Integer wareHouseID;
    private Integer shelfNo;
    private String PlacementDate;

    public CratePlacement() {
    }

    public CratePlacement(Integer wareHouseID, Integer shelfNo, String PlacementDate) {
        this.wareHouseID = wareHouseID;
        this.shelfNo = shelfNo;
        this.PlacementDate = PlacementDate;
    }

    public Integer getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(Integer wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public Integer getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(Integer shelfNo) {
        this.shelfNo = shelfNo;
    }

    public String getPlacementDate() {
        return PlacementDate;
    }

    public void setPlacementDate(String PlacementDate) {
        this.PlacementDate = PlacementDate;
    }

    @Override
    public String toString() {
        return "CratePlacement{" + "wareHouseID=" + wareHouseID + ", shelfNo=" + shelfNo + ", PlacementDate=" + PlacementDate + '}';
    }
    
}
