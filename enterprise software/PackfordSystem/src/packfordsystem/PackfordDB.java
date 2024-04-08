/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;
 import java.sql.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class PackfordDB {
   

     Connection con=null;
     String path="jdbc:ucanaccess://PackfordDB1.accdb";
   
        public  Connection ConnectDB(){
             try{
           
         
         Connection con = DriverManager.getConnection(path);
         System.out.println("connected");
          return con;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
}
        public Integer checkCredentials(String uname,String password) throws SQLException
                {
                    
                  this.con= this.ConnectDB();
            String sql = "SELECT * FROM Client";
             
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
                   
         while (result.next()) {
               String id= result.getString("Client_ID");
                String username = result.getString("username");
                String pass = result.getString("password");
                String name= result.getString("name");
                
               Client C;
               C = new Client();
               
               
                
                 
                System.out.println(id + ", " + username + ", " + password + ", " + id);
                return 1;
            }
         return 0;
                }
        
    
}
