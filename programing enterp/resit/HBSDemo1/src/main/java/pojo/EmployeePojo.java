package pojo;

import java.util.List;

import model.Department;
import model.Employee;
import model.Role;

public class EmployeePojo {

	private int id;
	
	private String firstName;
	
	private String LastName;
	
	private String password;
	
	private String email;
	
	private String empType;
	
	private int roleId;
	
	private int departmentId;
	
	private int reportingToId;
	
	private List<String> empTypes;
	
	private List<Role> roles;
	
	private List<Department> departments;
	
	private List<Employee> employees;
	
	private int holidatybal;

	private int totalholidays;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getReportingToId() {
		return reportingToId;
	}

	public void setReportingToId(int reportingToId) {
		this.reportingToId = reportingToId;
	}

	public List<String> getEmpTypes() {
		return empTypes;
	}

	public void setEmpTypes(List<String> empTypes) {
		this.empTypes = empTypes;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHolidatybal() {
		return holidatybal;
	}

	public void setHolidatybal(int holidatybal) {
		this.holidatybal = holidatybal;
	}

	public int getTotalholidays() {
		return totalholidays;
	}

	public void setTotalholidays(int totalholidays) {
		this.totalholidays = totalholidays;
	}

}
