package dao;

import java.util.List;

import javax.ejb.Local;

import model.Department;
import model.Role;


@Local
public interface IDepartment {

	public List<Department> getAllDepartments();
	
	public void addDepartment(Department dept);
	
	public void updateDepartment(Department dept);
	
	public Department getDepartment(int deptId);
	
	public void deleteDepartment(int deptId);
	
	public Department getDepartmentByName(String name);
}
