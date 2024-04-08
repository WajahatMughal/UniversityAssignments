//package servlet;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.enterprise.context.RequestScoped;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//
//import dao.HolidayManagementDTO;
//import dao.LoginBean;
//import model.Employee;
//import model.Holiday;
//import pojo.Login;
//
//@RequestScoped
//@Path("/employee")
//public class EmployeeResource {
//	
//	private LoginBean lgDao = new LoginBean();
//	
//	private HolidayManagementDTO holidayManagementDTO = new HolidayManagementDTO();
//	
//	@POST
//	@Path("/login")
//	public Employee login(Login login) {
//		Employee newDept = lgDao.authenticateByREST(login);
//		
//		if(newDept!= null) {
//			// User found in DB returning User Detail in response.
//			return newDept;
//		}else {
//			// User not Found
//			return null;
//		}
//		
//		
//	}
//	
//	@GET
//	@Path("/getleaves/{empId}")
//	public List<Holiday> getHolidaysForEmployee(@PathParam("empId") int empId) {
//		List<Holiday> leaves = new ArrayList<Holiday>();
//		
//		// get method all the leaves for employee and send list of Holidays in response
//		leaves.addAll(holidayManagementDTO.getAllLeaves(empId));
//		return leaves;
//		
//	}
//	
//
//}