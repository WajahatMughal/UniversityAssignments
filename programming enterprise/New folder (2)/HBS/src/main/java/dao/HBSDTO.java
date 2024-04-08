package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TblDepartment;
import model.TblStaff;

/**
 * Session Bean implementation class HBSDTO
 */
@Stateless
@LocalBean
public class HBSDTO {
	
	@PersistenceContext(unitName="HBSDAO")
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public HBSDTO() {
        // TODO Auto-generated constructor stub
    }
    
    public List<TblDepartment> allDepartment(){
    	List queryResults = em.createQuery("SELECT t FROM TblDepartment t").getResultList();
    	List<TblDepartment> listResult = new ArrayList<TblDepartment>();
    	
    	for(int i=0; i<queryResults.size(); i++) {
    		TblDepartment dpt = new TblDepartment();
    		dpt = (TblDepartment)queryResults.get(i);
    		listResult.add(dpt);
    	}
    	return listResult;
    	
    }

	
	public void insertStaff(String fname, String username, String password, String department, String role,	String joindate) {
		// TODO Auto-generated method stub
		TblStaff stf = new TblStaff();
		stf.setFname(fname);
		stf.setUsername(username);
		stf.setPassword(password);
		stf.setDepartment(department);
		stf.setRole(role);
		stf.setJoinDate(joindate);
		stf.setLeaveLimit(30);

		em.persist(stf);
		
		
	}
    
    

}
