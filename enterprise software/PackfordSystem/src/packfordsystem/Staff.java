/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packfordsystem;

/**
 *
 * @author user
 */
public class Staff extends User {
    private String department;
    private String Salary;

    public Staff(String department, String Salary) {
        this.department = department;
        this.Salary = Salary;
    }

    public Staff() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Staff{" + "department=" + department + ", Salary=" + Salary + '}';
    }
    
}
