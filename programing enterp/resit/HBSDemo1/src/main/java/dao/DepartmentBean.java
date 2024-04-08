package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Department;
import model.Role;


@Stateless
public class DepartmentBean implements IDepartment {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Department> getAllDepartments() {
    	List<Department> listResult = entityManager.createNamedQuery("Department.findAll", Department.class).getResultList();
    	
    	return listResult;
    }
    
    public void addDepartment(Department dept) {
    	entityManager.persist(dept);
    }
    
    public void updateDepartment(Department dept) {
    	entityManager.merge(dept);
    }
    
    public void deleteDepartment(int deptId) {
    	entityManager.remove(getDepartment(deptId));
    }
    
    public Department getDepartment(int deptId) {
        return entityManager.find(Department.class, deptId);
    }
    
    public Department getDepartmentByName(String name) {
    	List<Department> listResult = entityManager.createNamedQuery("Department.findByName", Department.class).setParameter("name", name).getResultList();
    	
    	if(listResult!= null && listResult.size()>0)
    		return listResult.get(0);
    	else
    		return null;
    }

}
