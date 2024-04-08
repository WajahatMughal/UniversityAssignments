package dao1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model1.Department;
import model1.Employee;
import model1.EmployeeDTO;
import model1.EmployeeStatus;
import model1.User;
import utils.ModelMapper;

/**
 * Session Bean implementation class EmployeeDTO
 */
@Stateless
@LocalBean
//@Remote(EmployeeManagerDTORemote.class)
@Path("Auth")
public class EmployeeManagerDTO /*implements EmployeeManagerDTORemote*/ {

	@PersistenceContext(unitName="HolidayBookingEJBWeb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public  EmployeeManagerDTO() {
        // TODO Auto-generated constructor stub
    }
    

	//@Override
	public void maintainEmploye(EmployeeDTO employeeDTO) {
		Employee employee = ModelMapper.convertDTOtoEmployee(employeeDTO);
    	em.persist(employee);
	}
	//@Override
    public void updateDetailFor(EmployeeDTO employee) {
	    em.createQuery("UPDATE Employee e SET e.department=:department,e.email=:email,e.joinDate=:joinDate,e.role=:role,e.password=:password WHERE e.id=:id")
	    .setParameter("email", employee.getEmail())
	    .setParameter("department", employee.getDepartment().toString())
	    .setParameter("joinDate", employee.getJoinDate())
	    .setParameter("role", employee.getRole().toString())
	    .setParameter("password", employee.getPassword())
	    .setParameter("id", employee.getId())
	    .executeUpdate();
	    em.createQuery("UPDATE Person p SET p.address=:address,p.dateOFBirth=:dob,p.name=:name,p.phoneNumber=:phoneNumber,p.postCode=:postCode WHERE p.id=:id")
	    .setParameter("id", employee.getId())
	    .setParameter("address",employee.getAddress())
	    .setParameter("dob", employee.getDateOFBirth())
	    .setParameter("name", employee.getName())
	    .setParameter("phoneNumber", employee.getPhoneNumber())
	    .setParameter("postCode", employee.getPostCode())
	    .executeUpdate();
	}
	
	public void updateNumberOFLeavesFor(EmployeeDTO employee) {
		  em.createQuery("UPDATE Employee e SET e.numberOfAllowedLeaves=:numberOfAllowedLeaves where e.id=:id")
		  .setParameter("numberOfAllowedLeaves", employee.getNumberOfAllowedLeaves())
		  .setParameter("id", employee.getId())
		  .executeUpdate();
	}

	//@Override
    public void removeEmployeeBy(int employeeID) {
    	Employee employee = em.find(Employee.class, employeeID);
    	em.remove(employee);
    }
    
	//@Override
    @SuppressWarnings("unchecked")
	public Boolean isVaild(String email, String password) {
    	Query query = em.createQuery("Select e from Employee e where e.email=:email And e.password =:password",Employee.class);
    	query.setParameter("email", email);
    	query.setParameter("password",password);
    	List<Employee> list = query.getResultList();
//      Employee employee = (Employee) query.getSingleResult();
    	if (list.size() > 0 ) {
		    return true; 
		 } else { 
	     	return false; 
	  }
    }
	//@Override
    public EmployeeDTO loginAs(String email, String password) {
    	Employee employee = em.createQuery("Select e from Employee e where e.email=:email And e.password =:password",Employee.class)
    			.setParameter("email", email)
    			.setParameter("password",password)
    			.getSingleResult();
    	EmployeeDTO employeeDTO = employee.convertEmployeeToDTO();
		return employeeDTO;
    }
	
	public List<Employee> employeeOnLeave(Date date) {
		long milliSec = date.getTime();
		 List<Employee> employeelist = em.createQuery("Select h.employee from Hoildayrequest h where h.fromDate<:time And h.toDate>:time",Employee.class)
    			.setParameter("time", milliSec)
    			.getResultList();
    	return  employeelist;
	}
	//@Override
	public List<EmployeeStatus> employeeStatusOn(Date date) {
		List<Employee> employeeListOnLeaves = employeeOnLeave(date);
		List<EmployeeDTO> employeeList = getEmployeeList();
		List<EmployeeStatus> employeeDTOList = new ArrayList<EmployeeStatus>();
		HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		for (Employee employee : employeeListOnLeaves ) {
			employeeMap.put(employee.getId(),employee);
		} 
		for (EmployeeDTO employee : employeeList) {
		EmployeeStatus status = new EmployeeStatus();
		status.setEmployee(employee);
			if (employeeMap.get(employee.getId()) != null ) {			
			    status.setWorking(false);
			} else {
				 status.setWorking(true);
			}
			employeeDTOList.add(status);
		}
		return employeeDTOList;
	}
	
	
	public List<Employee> employeeOnLeave(Date fromDate,Date toDate) {
		long fromMilliSec = fromDate.getTime();
		long toMilliSec = toDate.getTime();
		 List<Employee> employeelist = em.createQuery("Select h.employee from Hoildayrequest h where h.fromDate<:fromtime And h.toDate>:totime",Employee.class)
    			.setParameter("fromtime", fromMilliSec)
    			.setParameter("totime", toMilliSec)
    			.getResultList();
    	return  employeelist;
	}

	//@Override
	public List<EmployeeDTO> getEmployeeList() {
		List<Employee> employeeList = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		for (Employee employee : employeeList) {
			EmployeeDTO employeeDTO = employee.convertEmployeeToDTO() ;
			employeeDTOList.add(employeeDTO);
		}
		return employeeDTOList;
	}

	public List<EmployeeDTO> getEmployeeListBy(model1.Department employeeDepartment) {
		List<Employee> employeeList = em.createQuery("Select e from Employee e where e.department=:depart", Employee.class)
				                        .setParameter("depart", employeeDepartment.toString())
				                        .getResultList();
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		for (Employee employee : employeeList) {
			employeeDTOList.add(employee.convertEmployeeToDTO());
		}
		return employeeDTOList;
	}


	//@Override
	public EmployeeDTO getEmployeeBy(int id) {
		// TODO Auto-generated method stub
    	Employee employee = em.createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class)
    			.setParameter("id", id)
    			.getSingleResult();
       return employee.convertEmployeeToDTO();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmployeeDTO LoginEmployee(@Valid User user) {
		EmployeeDTO employee = loginAs(user.getEmail(), user.getPassword());
		return employee;
	}
	
}
