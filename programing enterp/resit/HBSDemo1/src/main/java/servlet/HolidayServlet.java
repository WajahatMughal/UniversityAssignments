package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IEmployee;
import dao.IHoliday;
import model.Employee;
import model.Holiday;
import pojo.HolidayPojo;  


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/holiday/*")
public class HolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IHoliday iHoliday;
	
	@EJB
	private IEmployee iEmployee;
	
	private static final List<String> srStaff = new ArrayList<String>() {
        {
            add("Manager");
            add("Senior member");
        }
    };
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
    public HolidayServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String action = request.getParameter("action");

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertHoliday(request, response);
                    break;
                case "delete":
                    deleteHoliday(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateHoliday(request, response);
                    break;
                case "updateleave":
                    updateHoliday(request, response);
                    break;
                case "listEmpLeaves":
                	listHolidaysByEmpId(request, response);
                    break;
                case "insertEmpLeave":
                	insertEmpLeave(request, response);
                    break;
                case "editEmpLeave":
                	editEmpLeave(request, response);
                    break;
                case "leavesForApprove":
                	getHolidaysToApprove(request, response);
                    break;
                    
                default:
                    listHolidays(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HolidayPojo holidaypojo = new HolidayPojo();
		List<Employee> employees = iEmployee.getAllEmployees();
		holidaypojo.setEmployees(employees);
		
    	request.setAttribute("holidaypojo", holidaypojo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidayEdit.jsp");
        dispatcher.forward(request, response);
    }
	
	private void editEmpLeave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
		int empid = (int) Long.parseLong(request.getParameter("empid"));
		
		HolidayPojo holidaypojo = new HolidayPojo();
		List<Employee> employees = iEmployee.getAllEmployees();
		holidaypojo.setEmployees(employees);
		
		holidaypojo.setEmployeeId(empid);
		Employee e = iEmployee.getEmployee(empid);
		
		request.setAttribute("Employee", e);
		request.setAttribute("empType", e.getRole().getName());
    	request.setAttribute("holidaypojo", holidaypojo);
    	request.setAttribute("violation", request.getParameter("violation"));
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidayEditForEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void listHolidays(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
        List<Holiday> holidays = iHoliday.getAllHolidays();
        request.setAttribute("holidays", holidays);
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidays.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listHolidaysByEmpId(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	int id = (int) Long.parseLong(request.getParameter("id"));
        List<Holiday> holidays = iHoliday.getAllHolidays(id);
        request.setAttribute("holidays", holidays);
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidays.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
    private void insertEmpLeave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
    	
    	Holiday newholiday = new Holiday();
        if(request.getParameter("id")!= null) {
        	newholiday.setId(Integer.parseInt(request.getParameter("id")));
        }
        Employee emp = null;
        if(request.getParameter("employeeId")!= null) {
        	emp = iEmployee.getEmployee(Integer.parseInt(request.getParameter("employeeId")));
        	newholiday.setEmployee(emp);
        	newholiday.setHod(emp.getHod());
        }
        
        Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		
		Date yearEndCondStartDate = sdf.parse("23-12-" + currentYear);
		Date yearEndCondEndDate = sdf.parse("03-01-" + (currentYear + 1));
		
    	long totalEmployess = iEmployee.getEmployeeCountByDeprartment(emp.getDepartment().getId());
    	
        newholiday.setReason(request.getParameter("reason"));
        newholiday.setStatus("RAISED");
        newholiday.setRequestdate(new Date());
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        
        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);  
        Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(toDate);  
        long difference = date2.getTime() - date1.getTime();
	    float daysBetween = (difference / (1000*60*60*24));
	    List<Date> dateList = new ArrayList<>();
	    
	    Date tempDate = date1;
	    for(int i=0 ; i<daysBetween; i++) {
	    	dateList.add(tempDate);
	    	Date dt = date1;
	        Calendar c = Calendar.getInstance();
	        c.setTime(dt);
	        c.add(Calendar.DATE, 1);
	        tempDate = c.getTime();
	    }
	    String violation = null;
	    for(Date date : dateList) {
	    	String resp = checkConstraints(date, yearEndCondStartDate, yearEndCondEndDate, totalEmployess, emp.getHod(), emp);
	    	
	    	if(resp != null) {
	    		violation = resp;
	    		break;
	    	}
	    }
	    
	    if(violation!= null) {
//	    	request.setAttribute("empid", emp.getId());
//	    	request.setAttribute("violation", request.getParameter("violation"));
//	    	editEmpLeave(request, response);
	    	response.sendRedirect("holiday?action=editEmpLeave&empid="+request.getParameter("employeeId")+"&violation="+violation);
	    }else {
	    	List<Holiday> holidays = new ArrayList<Holiday>();
	        if(daysBetween > 0){
	        	
	        	for(int i=0 ; i<daysBetween; i++) {
	        		Holiday holiday = new Holiday();
	        		holiday.setHod(newholiday.getHod());
	        		holiday.setEmployee(newholiday.getEmployee());
	        		holiday.setReason(newholiday.getReason());
	        		holiday.setRequestdate(newholiday.getRequestdate());
	        		holiday.setStatus(newholiday.getStatus());
	        		holiday.setHolidaydate(date1);
	            	holidays.add(holiday);
	            	
	            	Date dt = date1;
	    	        Calendar c = Calendar.getInstance();
	    	        c.setTime(dt);
	    	        c.add(Calendar.DATE, 1);
	    	        dt = c.getTime();
	    	        date1 = dt;
	        	}
	        	
	        }
	        
	        if(newholiday.getId()>0) {
	        	iHoliday.updateHoliday(newholiday);
	        }else {
	        	iHoliday.saveHoliday(holidays);
	        }
	        
	        response.sendRedirect("employeedash?action=main&id="+request.getParameter("employeeId")+"&type="+emp.getEmployeetype());
	    }
        
        
    }
    
    private void insertHoliday(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
    	
    	Holiday newholiday = new Holiday();
        if(request.getParameter("id")!= null) {
        	newholiday.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        newholiday.setReason(request.getParameter("reason"));
        newholiday.setStatus("RAISED");
        newholiday.setRequestdate(new Date());
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        
        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);  
        Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(toDate);  
        long difference = date2.getTime() - date1.getTime();
	    float daysBetween = (difference / (1000*60*60*24));
        Employee hod = new Employee();
        hod.setId(Integer.parseInt(request.getParameter("assignTo")));
        newholiday.setHod(hod);
        
        List<Holiday> holidays = new ArrayList<Holiday>();
        if(daysBetween > 0){
        	
        	for(int i=0 ; i<daysBetween; i++) {
        		Holiday holiday = new Holiday();
        		holiday.setHod(newholiday.getHod());
        		holiday.setReason(newholiday.getReason());
            	holiday.setRequestdate(newholiday.getRequestdate());
            	holiday.setStatus(newholiday.getStatus());
            	holidays.add(holiday);
            	Date dt = date1;
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.DATE, 1);
                dt = c.getTime();
                date1 = dt;
        	}
        	
        	
        }
        
        if(newholiday.getId()>0) {
        	iHoliday.updateHoliday(newholiday);
        }else {
        	iHoliday.saveHoliday(holidays);
        }
        
        response.sendRedirect("holiday?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        int id = (int) Long.parseLong(request.getParameter("id"));
        
        Holiday holiday = iHoliday.getHolidayById(id);
        
        HolidayPojo holidaypojo = new HolidayPojo();
		List<Employee> employees = iEmployee.getAllEmployees();
		holidaypojo.setEmployees(employees);
		holidaypojo.setAssignTo(holiday.getEmployee().getId());
		holidaypojo.setId(holiday.getId());
		holidaypojo.setReason(holiday.getReason());
		holidaypojo.setStatus(holiday.getStatus());
		
    	request.setAttribute("holidaypojo", holidaypojo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("holidayEdit.jsp");
        dispatcher.forward(request, response);

    }

    private void updateHoliday(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	int id = (int) Long.parseLong(request.getParameter("lId"));
        String status = request.getParameter("status");

        Holiday h = iHoliday.getHolidayById(id);
        if(status.equalsIgnoreCase("Approved")) {
        	h.setStatus("APPROVED");
        }else {
        	h.setStatus("REJECTED");
        }
        iHoliday.updateHoliday(h);
        response.sendRedirect("holiday?action=leavesForApprove&lId="+h.getEmployee().getId());
    }

    private void deleteHoliday(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       
    	int id = (int) Long.parseLong(request.getParameter("id"));
    	Holiday h = iHoliday.getHolidayById(id);
    	iHoliday.deleteHoliday(id);
        response.sendRedirect("employeedash?action=main&id="+h.getEmployee().getId());
    }
    
    public void getHolidaysToApprove (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	int empId = (int) Long.parseLong(request.getParameter("lId"));
    	
    	Employee emp = iEmployee.getEmployee(empId);
    	List<HolidayPojo> holidayList = new LinkedList<>();
    	
    	if(emp.getEmployeetype().equals("admin")) {
    		
    		List<Employee> hods = iEmployee.getAllHods("Head");
    		holidayList.addAll(getHolidayToApproveByHod(emp));
    		for(Employee hod : hods) {
    			holidayList.addAll(getHolidayToApproveByHod(hod));
    		}
    	} else {
    		holidayList = getHolidayToApproveByHod(emp);
    	}
    	
    	request.setAttribute("holidays", holidayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidays.jsp");
        dispatcher.forward(request, response);
    	
    }
    public void getHolidaysToApproveByHod (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    	int empId = (int) Long.parseLong(request.getParameter("id"));
    	
    	Employee hod = iEmployee.getEmployee(empId);
    	List<HolidayPojo> holidayList = new LinkedList<>();
    	
    	try {
    		
    		List<Holiday> holidays = iHoliday.getHolidaysToApproveByHod(hod.getId());
        	
        	Calendar calendar = new GregorianCalendar();
    		calendar.setTime(new Date());
    		int currentYear = calendar.get(Calendar.YEAR);
    		
    		Date yearEndCondStartDate = sdf.parse("23-12-" + currentYear);
    		Date yearEndCondEndDate = sdf.parse("03-01-" + (currentYear + 1));
    		
        	long totalEmployees = iEmployee.getEmployeeCountByDeprartment(hod.getDepartment().getId());
        	
        	for(Holiday h : holidays) {
        		HolidayPojo holiday = new HolidayPojo();
        		Employee emp = h.getEmployee();
        		
        		holiday.setId(h.getId());
        		holiday.setEmployeeName(emp.getFirstname() + " " + emp.getLastname());
        		holiday.setHolidayDate(sdf.format(h.getHolidaydate()));
        		holiday.setRequestedDate(sdf.format(h.getRequestdate()));
        		holiday.setStatus(h.getStatus());
        		
        		String status = checkConstraints(h.getHolidaydate(), yearEndCondStartDate, yearEndCondEndDate, totalEmployees, hod, h.getEmployee());
        		if(status != null) {
        			holiday.setIsViolating(true);
        			List<String> violationReasons = new ArrayList<String>();
        			violationReasons.add(status);
        			holiday.setViolations(violationReasons);
        		}
        		holidayList.add(holiday);
        	}
        	
    	} catch (ParseException pe) {
    		
    	} catch (Exception e) {
    		
    	}
    	request.setAttribute("holidays", holidayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("holidays.jsp");
        dispatcher.forward(request, response);
    }
    
    public void approveHoliday (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	int holidayId = (int) Long.parseLong(request.getParameter("holidayId"));
    	
    	Holiday holiday = iHoliday.getHolidayById(holidayId);
    	Employee hod = holiday.getHod();
    	
    }
    
    public void rejectHoliday (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	int holidayId = (int) Long.parseLong(request.getParameter("holidayId"));
    	
    	Holiday holiday = iHoliday.getHolidayById(holidayId);
    	holiday.setStatus("REJECTED");
    	iHoliday.updateHoliday(holiday);
    }
    
    private List<HolidayPojo> getHolidayToApproveByHod(Employee hod) {

    	List<HolidayPojo> holidayList = new LinkedList<>();
    	try {
    		
    		List<Holiday> holidays = iHoliday.getHolidaysToApproveByHod(hod.getId());
        	
        	Calendar calendar = new GregorianCalendar();
    		calendar.setTime(new Date());	
    		int currentYear = calendar.get(Calendar.YEAR);
    		
    		Date yearEndCondStartDate = sdf.parse("23-12-" + currentYear);
    		Date yearEndCondEndDate = sdf.parse("03-01-" + (currentYear + 1));
    		
        	long totalEmployees = iEmployee.getEmployeeCountByDeprartment(hod.getDepartment().getId());
        	
        	for(Holiday h : holidays) {
        		HolidayPojo holiday = new HolidayPojo();
        		Employee emp = h.getEmployee();
        		
        		holiday.setId(h.getId());
        		holiday.setEmployeeName(emp.getFirstname() + " " + emp.getLastname());
        		holiday.setHolidayDate(sdf.format(h.getHolidaydate()));
        		holiday.setRequestedDate(sdf.format(h.getRequestdate()));
        		holiday.setStatus(h.getStatus());
        		holiday.setReason(h.getReason());
        		
        		String status = null;
        		if(emp.getEmployeetype().equals("admin")) {
        			status = checkConstraints(h.getHolidaydate(), yearEndCondStartDate, yearEndCondEndDate, totalEmployees, h.getEmployee(), h.getEmployee());
        		} else {
        			status = checkConstraints(h.getHolidaydate(), yearEndCondStartDate, yearEndCondEndDate, totalEmployees, hod, h.getEmployee());
        		}
        				
        		if(status != null) {
        			holiday.setIsViolating(true);
        			List<String> violationReasons = new ArrayList<String>();
        			violationReasons.add(status);
        			holiday.setViolations(violationReasons);
        		} else {
        			holiday.setIsViolating(false);
        		}
        		holidayList.add(holiday);
        	}
        	
    	} catch (ParseException pe) {
    		
    	} catch (Exception e) {
    		
    	}
    	return holidayList;
    }

    public String checkConstraints(Date holidayDate, Date startDate, Date endDate, long totalEmployess, Employee hod, Employee emp) {
    	
    	String response = null;
    	int deptId = hod.getDepartment().getId();
    	
		// none of these constraints apply between the 23rd of December to the 3rd January of every year.
    	if(!holidayDate.after(startDate) && holidayDate.before(endDate)) {
    		
    		// At least one manager and one senior staff member must be on duty
    		if(srStaff.contains(emp.getRole().getName())) {
    			long totalSrStaff = iEmployee.getSrStaffCountByDeprartment(deptId, srStaff);
        		long srHolidaysApproved = iHoliday.getSrStaffHolidayCountByDateHodAndStatus(holidayDate, deptId, "APPROVED", srStaff);
        		
        		if(totalSrStaff - srHolidaysApproved < 2) {
        			return "Can not create / approve the holiday as all other Managers and Sr Staff members are also on leave.";
        		}
    		}
    		
    		long totalApprovedHolidays = iHoliday.getHolidayCountByDateHodAndStatus(holidayDate, hod.getId(), "APPROVED");
    		
    		if(totalApprovedHolidays > 0 && totalEmployess > 1) {
    			// In the month of August, the constraints are relaxed such that only 40% of a department must be on duty.
        		Calendar calendar = new GregorianCalendar();
        		calendar.setTime(holidayDate);
        		int currentMonth = calendar.get(Calendar.MONTH);
        		double staffOnHoliday = totalApprovedHolidays * 100 / totalEmployess;
        		
        		if(currentMonth == 7 && staffOnHoliday > 60) {
        			return "Can not create / approve the holiday as 60 percent staff is already on leave for August month.";
        		
        		} 
        		// At least 60% of a department must be on duty
        		else if (staffOnHoliday > 40){
        			return "Can not create / approve the holiday as 40 percent staff is already on leave.";
        		}
    		}
    		
    	} else {
    		response = "Holiday date falls under end of the year so no constraints will be applied.";
    	}
    	return response;
    }
}
