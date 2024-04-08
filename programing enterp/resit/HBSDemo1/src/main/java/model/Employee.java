package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e where e.id > 1")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;
	
	private String password;

	private String employeetype;

	private String firstname;

	private int holidaybal;

	private String lastname;

	private int totalholidays;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentid")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="reportingto")
	private Employee hod;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="hod")
	private List<Employee> employees;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	//bi-directional many-to-one association to Holiday
	@OneToMany(mappedBy="employee")
	private List<Holiday> holidays;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeetype() {
		return this.employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getHolidaybal() {
		return holidaybal;
	}

	public void setHolidaybal(int holidaybal) {
		this.holidaybal = holidaybal;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalholidays() {
		return this.totalholidays;
	}

	public void setTotalholidays(int totalholidays) {
		this.totalholidays = totalholidays;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getHod() {
		return hod;
	}

	public void setHod(Employee hod) {
		this.hod = hod;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Holiday> getHolidays() {
		return this.holidays;
	}

	public void setHolidays1(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public Employee(int id, String email, String firstname, String lastname) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(int id, String email, String employeetype, String firstname, String lastname) {
		super();
		this.id = id;
		this.email = email;
		this.employeetype = employeetype;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	

}