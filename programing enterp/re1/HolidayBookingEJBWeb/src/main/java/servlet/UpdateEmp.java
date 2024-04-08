package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.EmployeeManagerDTO;
import model1.Department;
import model1.EmployeeDTO;
import model1.Role;

/**
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/UpdateEmp/*")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	private EmployeeManagerDTO epDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getPathInfo();
		id = id.substring(1);
		if (id != null && id.length() != 0) {
			EmployeeDTO	employee = epDTO.getEmployeeBy(Integer.parseInt(id));
				request.setAttribute("employee", employee);
                request.getRequestDispatcher("/UpdateEmployeeForm.jsp").forward(request, response);
//				response.getWriter().append(id).append(request.getContextPath());
		}
		else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		String id = request.getPathInfo();
		id = id.substring(1);
		System.out.println(id);
		try{
		EmployeeDTO	employee = epDTO.getEmployeeBy(Integer.parseInt(id));
		
		EmployeeDTO admin = (EmployeeDTO) httpSession.getAttribute("user");
		if (admin.getRole() == Role.Admin) {
		String email = request.getParameter("email");
		String dept=request.getParameter("department");
		Department department = Department.valueOf("Office");//request.getParameter("department")
		Role role =  Role.valueOf("Head");//request.getParameter("role")
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postcode");
		String phonenumber = request.getParameter("phonenumber");
	    employee.setAddress(address);
	    employee.setRole(role);
	    employee.setDepartment(department);
	    employee.setPhoneNumber(phonenumber);
	    employee.setName(name);
	    employee.setEmail(email);
	    employee.setPostCode(postCode);
		epDTO.updateDetailFor(employee);
		
		response.setHeader("Location", request.getContextPath() + "/EmployeeList.jsp");
		
		//response.getWriter().append("{ \"error\":\""+ false +"\",\"status \": \"employee detail updated\"}");
		//request.getRequestDispatcher("AllRequestPage.jsp").forward(request, response);
			
	 } else { 
		 response.setContentType("application/json");
		 response.setStatus(403);
		 response.getWriter().append("{ \"error \": \""+ true +"\" , \"message\": \"Forbidden access\"}");
	 }} catch(NumberFormatException ex){ // handle your exception
		   //
		}
		//RequestDispatcher rd = request.getRequestDispatcher("EMServlet");
		//rd.forward(request,response);	
		
	}

}
