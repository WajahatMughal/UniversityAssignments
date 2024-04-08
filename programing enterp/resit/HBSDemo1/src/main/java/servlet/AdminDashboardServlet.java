package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ILogin;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/admindash/*")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ILogin login;

	public AdminDashboardServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			case "createEmployee":
//                	createEmployee(request, response);
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//            List<Department> deptList = deptDao.getAllDepartmentsNew();
//            request.setAttribute("listDepartment", deptList);
//            
//            // get employees
////            List<Employee> employees = deptDao.getAllDepartmentsNew();
//            request.setAttribute("employees", deptList);
//            
//            // get holidays
//            List<Holiday> holidays = deptDao.getAllLeaves();
            request.setAttribute("lId", request.getParameter("lId"));
            
//            String lId = null;
//            Cookie[] cookies = request.getCookies();
//            if(cookies !=null){
//            for(Cookie cookie : cookies){
//            	if(cookie.getName().equals("lId"))
//            	lId = cookie.getValue();
//            	response.addCookie(cookie);
//            	break;
//            }
//            }
//            
//            if(lId==null && lId!="") {
//	            Cookie loginCookie = new Cookie("lId",request.getParameter("lId"));
//				//setting cookie to expiry in 30 mins
//				loginCookie.setMaxAge(30*60);
//				response.addCookie(loginCookie);
//            }

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
		dispatcher.forward(request, response);

	}

	private void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String error = request.getParameter("error");
		request.setAttribute("error", error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

}
