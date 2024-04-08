package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IHoliday;
import dao.ILogin;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/employeedash/*")
public class EmployeeDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ILogin hmDao ;
	
	@EJB
	private IHoliday iholiday;
	
    public EmployeeDashboardServlet() {
        // TODO Auto-generated constructor stub
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
                case "main":
                    main(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("holidays", iholiday.getAllHolidays(Integer.parseInt(request.getParameter("id"))));
		
		request.setAttribute("empid", request.getParameter("id"));
		String type = request.getParameter("type");
		
		request.setAttribute("showButton", (type.equalsIgnoreCase("Head")));
		
	RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDashboard.jsp");
	dispatcher.forward(request, response);

}

}
