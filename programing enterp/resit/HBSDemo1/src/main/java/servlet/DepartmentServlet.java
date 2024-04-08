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

import dao.IDepartment;
import model.Department;


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/department/*")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IDepartment department;
	
    public DepartmentServlet() {
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
                    insertDept(request, response);
                    break;
                case "delete":
                    deleteDept(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateDept(request, response);
                    break;
                default:
                    listDepartments(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	request.setAttribute("dept", new Department());
    	request.setAttribute("error",request.getParameter("error"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
        List<Department> deptList = department.getAllDepartments();
        request.setAttribute("listDepartment", deptList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("department.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertDept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String deptName = request.getParameter("name");
        if(department.getDepartmentByName(deptName)== null) {
        	Department newDept = new Department();
            newDept.setName(deptName);
            department.addDepartment(newDept);
            response.sendRedirect("department?action=list");
        }else {
            response.sendRedirect("department?action=new&error=Name Already Exist.");
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        int id = (int) Long.parseLong(request.getParameter("id"));
        
   //     Department dept = hmDao.getDepartmentNew(id);
        Department dept = department.getDepartment(id);
        request.setAttribute("name", dept.getName());
        request.setAttribute("id", dept.getId());	
        RequestDispatcher dispatcher = request.getRequestDispatcher("departmentEdit.jsp?name="+dept.getName()+"&id="+dept.getId());
        dispatcher.forward(request, response);

    }

    private void updateDept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	int id = (int) Long.parseLong(request.getParameter("id"));
        String deptName = request.getParameter("name");

        Department dept = new Department();
        dept.setId(id);
        dept.setName(deptName);
        department.updateDepartment(dept);
        response.sendRedirect("department?action=list");
    }

    private void deleteDept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       
    	int id = (int) Long.parseLong(request.getParameter("id"));

        Department dept = new Department();
        dept.setId(id);
        department.deleteDepartment(id);
        response.sendRedirect("department?action=list");
    }

}
