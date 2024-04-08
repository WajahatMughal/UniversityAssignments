package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Employee;
import model.Holiday;

/**
 * Session Bean implementation class EmployeeDTO
 */
@Stateless
public class EmployeeBean implements IEmployee{

	@PersistenceContext
	private EntityManager entityManager;
	
    public EmployeeBean() {
        
    }
    
    public List<Employee> getAllEmployees() {
        
        List<Employee> employees = entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    	
    	return employees;
       
    }

    
    public void addEmployee(Employee emp) {
    	
    	entityManager.persist(emp);
    }
    
    public void updateEmployee(Employee emp) {
    	
    	entityManager.merge(emp);
    
   }
    
    public Employee getEmployee(int empId) {
    	
    	return entityManager.find(Employee.class, empId);
   }
    
    public void deleteEmployee(int empId) {
    	entityManager.remove(getEmployee(empId));
    	
    }

    public Long getEmployeeCountByDeprartment(int deptId) {
    	return entityManager.createQuery("SELECT count(1) FROM Employee e where e.department.id = :deptId", Long.class)
                .setParameter("deptId", deptId).getSingleResult();
        
    }
    
    public Long getSrStaffCountByDeprartment(int deptId, List<String> roles) {
    	return entityManager.createQuery("SELECT count(1) FROM Employee e where e.department.id = :deptId "
    			+ "and e.role.name in (:roles)", Long.class).setParameter("deptId", deptId).setParameter("roles", roles).getSingleResult();
        
    }

	@Override
	public List<Employee> getAllHods(String name) {
	 	return entityManager.createQuery("SELECT e FROM Employee e where e.role.name = :name", Employee.class)
                .setParameter("name", name).getResultList();
		
	}

}
