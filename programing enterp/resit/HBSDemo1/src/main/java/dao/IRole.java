package dao;

import java.util.List;

import javax.ejb.Local;

import model.Department;
import model.Role;


@Local
public interface IRole {

	public List<Role> getAllRoles();
	
	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public Role getRole(int roleId);
	
	public Role getRoleByName(String name);
	
	public void deleteRole(int roleId);
}
