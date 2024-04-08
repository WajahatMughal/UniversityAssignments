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
import model.Employee;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ILogin hmDao;
	
    public LoginServlet() {
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
                case "adminLogin":
                    Login(request, response);
                    break;
                case "employeeLogin":
                	Login(request, response);
                    break;
                case "redirectToLogin":
                	redirectToLogin(request, response);
                    break;
                case "logout":
                	logout(request, response);
                	break;
                default:
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lId = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
        	if(cookie.getName().equals("lId")) {
        		cookie.setValue(null);
        		cookie.setMaxAge(0);
            	response.addCookie(cookie);
        	}
        	if(cookie.getName().equals("name")) {
        		cookie.setValue(null);
        		cookie.setMaxAge(0);
            	response.addCookie(cookie);
        	}
        }
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
	}
	
    
    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String email = request.getParameter("name");
        String pass = request.getParameter("pass");

        Employee emp = new Employee();
        emp.setEmail(email);
        emp.setPassword(pass);
        emp = hmDao.authenticate(emp);
        
        
        
        if(emp== null) {
        	response.sendRedirect("login?action=redirectToLogin&error=Invalid Credential");
        }else{
        	String lId = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
            for(Cookie cookie : cookies){
            	if(cookie.getName().equals("lId"))
            	lId = cookie.getValue();
            	response.addCookie(cookie);
            	break;
            }
            }
            ;
            
            if(lId==null && lId!="") {
	            Cookie loginCookie = new Cookie("lId",emp.getId()+"");
	            Cookie loginNameCookie = new Cookie("name",emp.getFirstname()+" "+emp.getLastname());
	            Cookie empTypeCookie = new Cookie("empType",((emp.getEmployeetype().equalsIgnoreCase("admin"))?"" :emp.getRole().getName()));
	            Cookie isAdminCookie = new Cookie("isadmin",(emp.getEmployeetype().equalsIgnoreCase("admin"))+"");
	            
				//setting cookie to expiry in 30 mins
				loginCookie.setMaxAge(30*60);
				loginNameCookie.setMaxAge(30*60);
				response.addCookie(loginCookie);
				response.addCookie(loginNameCookie);
				response.addCookie(empTypeCookie);
				response.addCookie(isAdminCookie);
				response.addCookie(isAdminCookie);
            }
            
        	if(emp.getEmployeetype().equalsIgnoreCase("admin")) {
        		response.sendRedirect("admindash?action=main&lId="+emp.getId());
        	}else {
        		response.sendRedirect("employeedash?action=main&id="+emp.getId()+"&type="+emp.getRole().getName());
        	}
        		
        }
        
    }
    
    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String error = request.getParameter("error");
        request.setAttribute("error", error);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

}
