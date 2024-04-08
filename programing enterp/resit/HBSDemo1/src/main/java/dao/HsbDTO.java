package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Department;

/**
 * Session Bean implementation class HsbDTO
 */
@Stateless
@LocalBean
public class HsbDTO {

	@PersistenceContext(unitName = "HBSDemo1")
    EntityManager em;
	
    public HsbDTO() {
        // TODO Auto-generated constructor stub
    }

    public List<Department> allDepartments() {
    	List depts = em.createQuery("select d from Department d").getResultList();
    	
    	List<Department> deptList = new ArrayList<>();
    	
    	for(int i =0; i < depts.size(); i++) {
    		Department dept = new Department();
    		dept = (Department) depts.get(i);
    		deptList.add(dept);
    	}
    	return deptList;
    }
}
