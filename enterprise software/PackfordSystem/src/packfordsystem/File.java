/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class File {
   private Integer FileID;
   private String type;

    public File() {
    }

    public File(Integer FileID, String type) {
        this.FileID = FileID;
        this.type = type;
    }

    public Integer getFileID() {
        return FileID;
    }

    public void setFileID(Integer FileID) {
        this.FileID = FileID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
            
    
}
