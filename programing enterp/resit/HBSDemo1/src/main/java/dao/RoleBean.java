package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Department;
import model.Role;


@Stateless
public class RoleBean implements IRole {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Role> getAllRoles() {
    	List<Role> listResult = entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
    	
    	return listResult;
    }
    
    public void addRole(Role role) {
    	entityManager.persist(role);
    }
    
    public void updateRole(Role role) {
    	entityManager.merge(role);
    }
    
    public void deleteRole(int roleId) {
    	entityManager.remove(getRole(roleId));
    }
    
    public Role getRole(int roleId) {
        return entityManager.find(Role.class, roleId);
    }
    
    public Role getRoleByName(String name) {
    	List<Role> listResult = entityManager.createNamedQuery("Role.findByName", Role.class).setParameter("name", name).getResultList();
    	
    	if(listResult!= null && listResult.size()>0)
    		return listResult.get(0);
    	else
    		return null;
    }

}
