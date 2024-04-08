package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.EmployeeManagerDTO;
import dao1.HolidayManagerDTO;
import model1.EmployeeDTO;
import model1.HolidayDTO;
import model1.Role;

/**
 * Servlet implementation class AllRequest
 */
@WebServlet("/AllRequest")
public class AllRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmployeeManagerDTO epDTO;
	
	@EJB
	public HolidayManagerDTO hdDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllRequestServlet() {
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
		if(admin.getRole() == Role.Admin) {
			List<EmployeeDTO> employee = epDTO.getEmployeeList();
			request.setAttribute("employeeList", employee);
			List<HolidayDTO> requestList = hdDTO.listOfHolidayRequestBy(null);
			request.setAttribute("requestlist",requestList);
			request.getRequestDispatcher("AllRequestPage.jsp").forward(request, response);
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
		if(admin.getRole() == Role.Admin) {
			int employeeID = Integer.parseInt(request.getParameter("Employee"));
			EmployeeDTO employee = epDTO.getEmployeeBy(employeeID);
			List<EmployeeDTO> employeelist = epDTO.getEmployeeList();
			request.setAttribute("employeeList", employeelist);
			List<HolidayDTO> requestList = hdDTO.listOfHolidayRequestBy(employee);
			request.setAttribute("requestlist",requestList);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("AllRequestPage.jsp").forward(request, response);
		}
	}

}
