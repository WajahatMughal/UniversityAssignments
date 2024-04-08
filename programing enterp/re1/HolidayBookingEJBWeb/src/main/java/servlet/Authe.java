package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.EmployeeManagerDTO;
import model1.EmployeeDTO;

/**
 * Servlet implementation class Authe
 */
@WebServlet("/Authe")
public class Authe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeManagerDTO epDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	   Boolean isValid = epDTO.isVaild(email, password); 
	    System.out.println(isValid);
		if (isValid) {
			// set session
			EmployeeDTO employee = epDTO.loginAs(email, password);
			HttpSession httpSession = request.getSession(Boolean.TRUE);
			httpSession.setMaxInactiveInterval(15*60);
			httpSession.setAttribute("user", employee);
			// re direct to role page
			response.sendRedirect("Dashboard");
		} else {
			request.setAttribute("Loginfailed", true);
			request.setAttribute("Message", "wrong username/password enterd");
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
