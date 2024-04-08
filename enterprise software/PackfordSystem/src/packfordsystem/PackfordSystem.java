/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class PackfordSystem {
    
    public static PackfordDB db=new PackfordDB();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        
        // TODO code application logic here
        System.out.println("Hello world");
        LoginForm log;
        log = new LoginForm();
        log.show(true);
          System.out.println("Hello wowrld");
    }
    
}
