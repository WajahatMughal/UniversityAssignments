package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IRole;
import model.Role;


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/role/*")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IRole role;
	
    public RoleServlet() {
    	super();
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
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertRole(request, response);
                    break;
                case "delete":
                    deleteRole(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateRole(request, response);
                    break;
                default:
                    listRoles(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	request.setAttribute("role", new Role());
    	request.setAttribute("error",request.getParameter("error"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("newRole.jsp");
        dispatcher.forward(request, response);
    }

    private void listRoles(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
        List<Role> roles = role.getAllRoles();
        request.setAttribute("listRoles", roles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("role.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertRole(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String roleName = request.getParameter("name");
        
        if(role.getRoleByName(roleName)== null) {
        	 Role newRole = new Role();
             newRole.setName(roleName);
             role.addRole(newRole);
             response.sendRedirect("role?action=list");
        }else {
        	response.sendRedirect("role?action=new&error=Name Already Exist.");
        }

       
        
        
        
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        int id = (int) Long.parseLong(request.getParameter("id"));
        
        Role roleobj = role.getRole(id);
        request.setAttribute("name", roleobj.getName());
        request.setAttribute("id", roleobj.getId());	
        RequestDispatcher dispatcher = request.getRequestDispatcher("roleEdit.jsp?name="+roleobj.getName()+"&id="+roleobj.getId());
        dispatcher.forward(request, response);

    }

    private void updateRole(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	int id = (int) Long.parseLong(request.getParameter("id"));
        String roleName = request.getParameter("name");

        Role roleobj = new Role();
        roleobj.setId(id);
        roleobj.setName(roleName);
        role.updateRole(roleobj);
        response.sendRedirect("role?action=list");
    }

    private void deleteRole(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       
    	int id = (int) Long.parseLong(request.getParameter("id"));
        role.deleteRole(id);
        response.sendRedirect("role?action=list");
    }

}
