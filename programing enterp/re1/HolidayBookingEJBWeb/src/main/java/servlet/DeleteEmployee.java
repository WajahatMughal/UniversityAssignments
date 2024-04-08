package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.EmployeeManagerDTO;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee/*")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private EmployeeManagerDTO epDTO;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     String id = request.getPathInfo();
	     id = id.substring(1);
	     epDTO.removeEmployeeBy(Integer.parseInt(id));
	     response.sendRedirect(request.getContextPath()+"/Employee");
	}

}
