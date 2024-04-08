package dao;

import java.util.List;

import javax.ejb.Local;

import model.Employee;

@Local
public interface IEmployee {

	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee emp);
	
	public void updateEmployee(Employee emp);
	
	public void deleteEmployee(int empId);
	
	public Employee getEmployee(int empId);
	
	public Long getEmployeeCountByDeprartment(int deptId);
	
	public Long getSrStaffCountByDeprartment(int roleId, List<String> roles);
	
	public List<Employee> getAllHods(String name);
	
}
