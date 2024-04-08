package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.EmployeeManagerDTO;
import model1.Dates;
import model1.Department;
import model1.EmployeeDTO;
import model1.Role;

/**
 * Servlet implementation class EMServlet
 */
@WebServlet("/EMServlet")
public class EMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeManagerDTO epDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO admin = (EmployeeDTO) httpSession.getAttribute("user");
		if (admin.getRole() == Role.Admin) {
			  List<EmployeeDTO> employeeList = epDTO.getEmployeeList();
			  employeeList = employeeList.stream().filter(employee -> employee.getId() != 1)
					                                       .collect(Collectors.toList());
			  request.setAttribute("employeelist", employeeList);
			  request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
		} else {
			 response.setContentType("application/json");
			 response.setStatus(403);
			 response.getWriter().append("{ \"error \": \""+ true +"\" , \"message\": \"Forbidden access\"}");
		 }
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO admin = (EmployeeDTO) httpSession.getAttribute("user");
		if (admin.getRole() == Role.Admin) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String joinDateString = request.getParameter("joindate");
		long joinDate =Dates.toTimeStamp(joinDateString);
		Department department = Department.valueOf(request.getParameter("department"));
		Role role =  Role.valueOf(request.getParameter("role"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postcode");
		String phonenumber = request.getParameter("phonenumber");
		String 	dateofbirthString = request.getParameter("dateofbirth");
		long dateofbirth = Dates.toTimeStamp(dateofbirthString);
		EmployeeDTO employee = new EmployeeDTO(
				department, 
				email,
				joinDate,
				30, 
				password, 
				role, 
				address, 
				dateofbirth,
				name, 
				phonenumber, 
				postCode);
		epDTO.maintainEmploye(employee);
		response.setContentType("application/json");
		response.setStatus(200);
		response.getWriter().append("{ \"error\":\""+ false +"\",\"status \": \"employee added\"}");
	 } else {
		 response.setContentType("application/json");
		 response.setStatus(403);
		 response.getWriter().append("{ \"error \": \""+ true +"\" , \"message\": \"Forbidden access\"}");
	 }
   }

}
