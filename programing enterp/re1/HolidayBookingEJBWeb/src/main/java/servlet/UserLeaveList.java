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

import dao1.HolidayManagerDTO;
import model1.EmployeeDTO;
import model1.HolidayDTO;

/**
 * Servlet implementation class UserLeaveList
 */
@WebServlet("/UserLeaveList")
public class UserLeaveList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HolidayManagerDTO hdDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLeaveList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO employee = (EmployeeDTO) httpSession.getAttribute("user");
		if (employee != null) {
	      List<HolidayDTO> list = hdDTO.listOfHolidayRequestBy(employee);
	      request.setAttribute("employee",employee);
	      request.setAttribute("requestlist",list);
		  request.getRequestDispatcher("UserLeaveRequest.jsp").forward(request, response);
		} else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
