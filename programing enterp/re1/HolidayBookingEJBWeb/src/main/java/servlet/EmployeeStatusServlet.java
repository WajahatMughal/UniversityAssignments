package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.EmployeeManagerDTO;
import model1.Dates;
import model1.EmployeeDTO;
import model1.EmployeeStatus;
import model1.Role;

/**
 * Servlet implementation class EmployeeStatus
 */
@WebServlet("/EmployeeStatus")
public class EmployeeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	@EJB
	private EmployeeManagerDTO epDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeStatusServlet() {
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
             request.getRequestDispatcher("EmployeeStatusPage.jsp").forward(request, response);     
		} else { 
			response.getWriter().append("Served at: ").append(request.getContextPath());	
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
			 String selectedDateString = request.getParameter("date");
			 long selectedDateLong = Dates.toTimeStamp(selectedDateString);
			 Date selectedDate = new Date(selectedDateLong);
			 List<EmployeeStatus> list = epDTO.employeeStatusOn(selectedDate);
			 request.setAttribute("employeelist", list);
			 request.setAttribute("date", selectedDate);
             request.getRequestDispatcher("EmployeeStatusPage.jsp").forward(request, response);     
		} else { 
			response.getWriter().append("Served at: ").append(request.getContextPath());	
		} 
	}

}
