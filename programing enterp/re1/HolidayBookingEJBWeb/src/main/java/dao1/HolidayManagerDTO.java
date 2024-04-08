package dao1;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model1.Dates;
import model1.Department;
import model1.Employee;
import model1.EmployeeDTO;
import model1.Hoildayrequest;
import model1.HolidayDTO;
import model1.Leaveslog;
import model1.ResponseMessage;
import model1.Role;
import model1.Status;
import rest.LeaveModel;
import utils.ModelMapper;

/**
 * Session Bean implementation class HolidayDTO
 */
@Stateless
@LocalBean
//@Remote(HolidayManagerDTORemote.class)
@Path("LeaveRequest")
public class HolidayManagerDTO /*implements HolidayManagerDTORemote*/ {

	@PersistenceContext(unitName="HolidayBookingEJBWeb")
	EntityManager em;
	
	   
	@EJB
	private EmployeeManagerDTO epDTO;
	
    /**
     * Default constructor. 
     */
    public HolidayManagerDTO() {
        // TODO Auto-generated constructor stub
    }

	//@Override
	public void applyForLeave(HolidayDTO holiday) {
		Hoildayrequest hoildayRequest = ModelMapper.convertToHolidayfromDTO(holiday);
		em.persist(hoildayRequest);
	}

	//@Override
	public List<HolidayDTO> listOFLeavePendingLeaveRequest() {
	    List<Hoildayrequest> leaveRequestList = em.createQuery("Select h from Hoildayrequest h where h.status='Pending' ",Hoildayrequest.class).getResultList();
	    requestSorting(leaveRequestList,0,leaveRequestList.size() - 1);
	    List<HolidayDTO> pendingLeaves = new ArrayList<HolidayDTO>();
	    for(Hoildayrequest request : leaveRequestList) {
	    	pendingLeaves.add(request.convertToDTOfromholidayRequest());
	    }
		return pendingLeaves;
	}

	@GET 
	@Path("/{employeeID}") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<HolidayDTO> appliyedLeaveRequest(@PathParam("employeeID") int id) {
	         EmployeeDTO employee = epDTO.getEmployeeBy(id);
	         List<HolidayDTO> requestList = listOfHolidayRequestBy(employee);
	         return requestList;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMessage placeLeaveRequest(LeaveModel request) {
		    long fromDateLong = Dates.toTimeStamp(request.getFromDate());
		    long toDateLong = Dates.toTimeStamp(request.getToDate());
		    Date fromdate = new Date(fromDateLong);
		    Date todate = new Date(toDateLong);
		    EmployeeDTO employee = epDTO.getEmployeeBy(request.getEmployeeID());
		    HolidayDTO holiday = new HolidayDTO(fromdate, Dates.numberOFDays(fromdate, todate),request.getReason(), Status.Pending,todate);
		    holiday.setEmployee(employee);
        	applyForLeave(holiday);
        	ResponseMessage response = new ResponseMessage();
        	response.setError(false);
        	response.setMessage("Leave Request submited");
        	return response;
	}
	
	//@Override
	public HolidayDTO getLeaveRequestBy(int id) {
		// TODO Auto-generated method stub
		Hoildayrequest holiday = em.createQuery("SELECT h FROM Hoildayrequest h WHERE h.id=:id", Hoildayrequest.class)
    			.setParameter("id", id)
    			.getSingleResult();
       return holiday.convertToDTOfromholidayRequest();
	}
	
	//@Override
	public void updateStatusRequest(HolidayDTO holiday) {
		// TODO Auto-generated method stub
		if((holiday.getStatus() == Status.Accept) && (!checkForHolidaySession(holiday))) {
			updateLeaveLogFor(holiday);
		}
	    em.createQuery("UPDATE Hoildayrequest h SET h.status=:state WHERE h.id=:id")
	    .setParameter("state", holiday.getStatus().toString())
	    .setParameter("id", holiday.getId())
	    .executeUpdate();
	}
	
	private void updateLeaveLogFor(HolidayDTO holiday) {
		Leaveslog log = new Leaveslog();
		Employee employee = ModelMapper.convertDTOtoEmployee(holiday.getEmployee());
		CheckForNumberOFLeavesIncresed(employee);
		log.setEmployee(employee);
		log.setDate(holiday.getToDate().getTime());
		Leaveslog latestLog = getLastLeaveLogFor(employee); 
		if (latestLog != null) {
		Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(latestLog.getDate()); 
        int lastLeaveyear = cal.get(Calendar.YEAR);
	    cal.setTime(holiday.getToDate()); 
        int currentLeaveYear = cal.get(Calendar.YEAR);
		if (currentLeaveYear > lastLeaveyear) {
		  cal.setTime(holiday.getFromDate());
		  int currentLeaveFromYear = cal.get(Calendar.YEAR);
		  if (currentLeaveFromYear > lastLeaveyear) {
			  cal.setTime(holiday.getToDate());
			  Calendar cal2 = Calendar.getInstance();
			  cal2.set(Calendar.YEAR, currentLeaveFromYear);
			  cal2.set(Calendar.DATE, 1);
			  cal2.set(Calendar.MONTH, 0);
			  long numberOfDays = ChronoUnit.DAYS.between(cal2.toInstant(),cal.toInstant());
			  int leftLeaves = (int) (employee.getNumberOfAllowedLeaves() - numberOfDays);
			  log.setLeavesLeft(leftLeaves);
		  } else {
			  int numberLeaveCurrent = employee.getNumberOfAllowedLeaves() - holiday.getNumberOfDate();
			  log.setLeavesLeft(numberLeaveCurrent);
		  }
		} else {
		  int numberLeaveCurrent = latestLog.getLeavesLeft() - holiday.getNumberOfDate(); 
		  log.setLeavesLeft(numberLeaveCurrent);
		}
	 } else {
		  int numberLeaveCurrent = employee.getNumberOfAllowedLeaves() - holiday.getNumberOfDate();
		  log.setLeavesLeft(numberLeaveCurrent);
	 }
		em.persist(log);
	}
	
	private Leaveslog getLastLeaveLogFor(Employee employee) {
	 Leaveslog leavelog = null;
	 List<Leaveslog> logs = em
		    		.createQuery("Select l from Leaveslog l where l.employee.id=:employeeID ORDER BY l.date ASC",Leaveslog.class)
		    		.setParameter("employeeID", employee.getId())
		    		.getResultList();
	 if (logs.size() > 0 ) {
		 leavelog = logs.get(0);
	 }
	 return leavelog;
	}
	

	//@Override
	public List<HolidayDTO> listOfHolidayRequestBy(EmployeeDTO employee) {
		if (employee != null) {
	    List<Hoildayrequest> leaveRequestList = em
	    		.createQuery("Select h from Hoildayrequest h where h.employee.id=:id",Hoildayrequest.class)
	    		.setParameter("id", employee.getId())
	    		.getResultList();
	    List<HolidayDTO> leaves =  new ArrayList<HolidayDTO>();
	    for(Hoildayrequest request : leaveRequestList) {
	    	leaves.add(request.convertToDTOfromholidayRequest());
	    }
		return leaves;
		} else {
			List<Hoildayrequest> leaveRequestList = em
		    		.createQuery("Select h from Hoildayrequest h",Hoildayrequest.class).getResultList();
		    List<HolidayDTO> leaves =  new ArrayList<HolidayDTO>();
		     for(Hoildayrequest request : leaveRequestList) {
                 leaves.add(request.convertToDTOfromholidayRequest());
		      }
		    return leaves;
		}
	}

	//@Override
	public List<String> contrantsCheckFor(HolidayDTO holiday) {
		List<String> constraits = new ArrayList<String>();
		if (!checkForHolidaySession(holiday)) {
			checkForisLeaveAvailable(constraits,holiday);
			checkForDepartmentHeadIsNotLeave(constraits,holiday);
			checkForDepartmentseniorstaffmemberIsNotLeave(constraits,holiday);
			checkForWorkStrength(constraits,holiday);
	    } 
		 return constraits;
	}
	
	
	private void CheckForNumberOFLeavesIncresed(Employee employee) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(employee.getJoinDate());
		int year = cal.get(Calendar.YEAR);
		cal.set(Calendar.YEAR, year + 1);
		long currentTime = System.currentTimeMillis();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(currentTime);
		int currentYear = cal2.get(Calendar.YEAR);
		if (cal.after(cal2)) {
			int dif = currentYear - year;
			int numberOfLeavesAdded = dif / 5 ;
			int numberOfAllowedLeaves = 30 + numberOfLeavesAdded;
			employee.setNumberOfAllowedLeaves(numberOfAllowedLeaves);
			EmployeeDTO employeeDTO = employee.convertEmployeeToDTO();
			epDTO.updateNumberOFLeavesFor(employeeDTO);
		}
	}
	
	private void checkForDepartmentHeadIsNotLeave(List<String> constraits,HolidayDTO holidays) {
		EmployeeDTO employee = holidays.getEmployee();
		Department employeeDepartment = employee.getDepartment();
		Role employeeRole = employee.getRole();
		if ((employeeRole == Role.Head)||(employeeRole == Role.DeputyHead)) {
			List<Employee> employeeList = epDTO.employeeOnLeave(holidays.getFromDate(),holidays.getToDate());
			for ( Employee employeeCurrent : employeeList ) {
				EmployeeDTO employeeDTO = employeeCurrent.convertEmployeeToDTO();
				if (employeeDTO.getDepartment() == employeeDepartment) {
					if ((employeeDTO.getRole() == Role.Head)||(employeeDTO.getRole() == Role.DeputyHead)) {
						constraits.add("Departments head or deputy head needs to be in duty");
						break;
					}
				} 
			}
			
		}    	
	}
	
	private void checkForDepartmentseniorstaffmemberIsNotLeave(List<String> constraits,HolidayDTO holidays) {
		EmployeeDTO employee = holidays.getEmployee();
		Department employeeDepartment = employee.getDepartment();
		Role employeeRole = employee.getRole();
		if ((employeeRole == Role.SeniorMember)||(employeeRole == Role.Manager)) {
			List<Employee> employeeList = epDTO.employeeOnLeave(holidays.getFromDate(),holidays.getToDate());
			for ( Employee employeeCurrent : employeeList ) {
				EmployeeDTO employeeDTO = employeeCurrent.convertEmployeeToDTO();
				if (employeeDTO.getDepartment() == employeeDepartment) {
					if ((employeeDTO.getRole() == Role.SeniorMember)||(employeeDTO.getRole() == Role.Manager)) {
						constraits.add("departments least one manger and senior staff member must be on duty");
						break;
					}
				} 
			}	
		}  
	}
	
	private void checkForWorkStrength(List<String> constraits,HolidayDTO holidays) {
		List<Employee> employeeList = epDTO.employeeOnLeave(holidays.getFromDate(),holidays.getToDate());
		EmployeeDTO employee = holidays.getEmployee();
		Department employeeDepartment = employee.getDepartment();
		double totalEmployee = epDTO.getEmployeeListBy(employeeDepartment).size();
		double employeeOnLeaves = 1;
		for (Employee employeeCurrent : employeeList) {
			EmployeeDTO employeeDTO = employeeCurrent.convertEmployeeToDTO();
			if (employeeDTO.getDepartment() == employeeDepartment) {
			       employeeOnLeaves += 1;
			}
		}
		double numberEmployeeWorking = totalEmployee - employeeOnLeaves;
		double departmentStrength = (numberEmployeeWorking / totalEmployee);
		if((checkForPeakHour(holidays))&&(departmentStrength < 0.6)) {
			constraits.add("department strength has been drop below 60%");
		} else
		if (departmentStrength < 0.4){
			constraits.add("department strength has been drop below 40%");
		}
	}
	
	private void checkForisLeaveAvailable(List<String> constraits,HolidayDTO holiday) {
		Employee employee = ModelMapper.convertDTOtoEmployee(holiday.getEmployee());
		Leaveslog latestLog = getLastLeaveLogFor(employee); 
		Calendar cal = Calendar.getInstance();
		if (latestLog != null) {
	    cal.setTimeInMillis(latestLog.getDate()); 
        int lastLeaveyear = cal.get(Calendar.YEAR);
	    cal.setTime(holiday.getFromDate()); 
        int currentLeaveYear = cal.get(Calendar.YEAR);
		int numberLeavesNeeded = holiday.getNumberOfDate();
		if (currentLeaveYear > lastLeaveyear) {
			int numberLeavesAvailable = employee.getNumberOfAllowedLeaves();
			if (numberLeavesAvailable < numberLeavesNeeded) {
				constraits.add("Out of number of leaves available");
			}
		} else {
			int numberLeavesAvailable = latestLog.getLeavesLeft();
			if (numberLeavesAvailable < numberLeavesNeeded) {
				constraits.add("Out of number of leaves available");
			}
		}
	  }
	}
	private void requestSorting(List<Hoildayrequest> arr,int start, int end) {	 
		    if (start < end) {
		        int m = start + (end - start) / 2;
		        requestSorting(arr, start, m);
		        requestSorting(arr, m + 1, end);
		        join(arr, start, m, end);
		    }		  
	  
	}
	
	void join(List<Hoildayrequest> arr, int l, int m, int r)
	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 = r - m;

	    List<Hoildayrequest> L = new ArrayList<Hoildayrequest>();
	    List<Hoildayrequest> R = new ArrayList<Hoildayrequest>();

	    for (i = 0; i < n1; i++)
	        L.add(arr.get(l + i));
	    for (j = 0; j < n2; j++)
	        R.add(arr.get(m + 1 + j));
	    i = 0; 
	    j = 0; 
	    k = l; 
	    while (i < n1 && j < n2) {
	        if (checkPriorities(L.get(i),R.get(j))){
	            arr.set(k, L.get(i)); 
	            i++;
	        }
	        else {
	            arr.set(k, R.get(j));
	            j++;
	        }
	        k++;
	    }
	    while (i < n1) {
	        arr.set(k, L.get(i));
	        i++;
	        k++;
	    }
	    while (j < n2) {
	    	arr.set(k, R.get(j));
	        j++;
	        k++;
	    }
	}
	  

	
	private Boolean checkPriorities(Hoildayrequest leave1, Hoildayrequest leave2) {
		Employee emp1 = leave1.getEmployee();
		Employee emp2 = leave2.getEmployee();
		Leaveslog log1 = getLastLeaveLogFor(emp1);
		Leaveslog log2 = getLastLeaveLogFor(emp2);
		if ((log2 != null) &&(log1 != null) ) {
		return log1.getLeavesLeft() > log2.getLeavesLeft(); 
		} else {
		 return true;	
		}
	}
     
	private Boolean checkForPeakHour(HolidayDTO holiday) {
		Calendar cal1 = Calendar.getInstance();
		LocalDate date = LocalDate.now();
		cal1.set(date.getYear(), 6, 15);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(date.getYear(), 8, 31);
	  return (cal1.after(holiday.getFromDate()))&&(cal2.before(holiday.getToDate()));
	}
	
	private Boolean checkForHolidaySession(HolidayDTO holiday) {
		Calendar cal1 = Calendar.getInstance();
		LocalDate date = LocalDate.now();
		cal1.set(date.getYear(), 11, 23);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(date.getYear() + 1, 0, 3);
	  return (cal1.after(holiday.getFromDate()))&&(cal2.before(holiday.getToDate()));
	}

}
