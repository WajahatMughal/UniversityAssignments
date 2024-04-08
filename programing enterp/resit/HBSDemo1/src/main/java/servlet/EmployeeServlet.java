package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDepartment;
import dao.IEmployee;
import dao.IRole;
import model.Department;
import model.Employee;
import model.Role;
import pojo.EmployeePojo;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/employee/*")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IEmployee hmDao;
	
	@EJB
	private IDepartment iDepartment;
	
	@EJB
	private IRole iRole;
	
    public EmployeeServlet() {
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
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                	insertEmp(request, response);
                    break;
                case "delete":
                    deleteEmp(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmp(request, response);
                    break;
                default:
                	listEmployees(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	request.setAttribute("emp", new Employee());
    	
    	List<Department> departments = iDepartment.getAllDepartments();
    	List<Role> roles = iRole.getAllRoles();
    	List<Employee> employees = hmDao.getAllEmployees();
    	List<String> empTypes = new ArrayList<String>();
    	empTypes.add("admin");
    	empTypes.add("staff");
    	
    	EmployeePojo employeepojo = new EmployeePojo();
    	employeepojo.setDepartments(departments);
    	employeepojo.setRoles(roles);
    	employeepojo.setEmployees(employees);
    	employeepojo.setEmpTypes(empTypes);
    	
    	request.setAttribute("employeepojo", employeepojo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeEdit.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
        List<Employee> empList = hmDao.getAllEmployees();
        request.setAttribute("empList", empList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        Employee emp = new Employee();
        
        if(request.getParameter("id")!= null && Integer.parseInt(request.getParameter("id"))>0) {
        	emp.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        emp.setFirstname(request.getParameter("firstname"));
        emp.setLastname(request.getParameter("lastname"));
        
        Department dept = new Department();
        dept.setId(Integer.parseInt(request.getParameter("departmentid")));
        emp.setDepartment(dept);
        
        Role role = new Role();
        role.setId(Integer.parseInt(request.getParameter("roleId")));
        emp.setRole(role);

        Employee hod = new Employee();
        hod.setId(Integer.parseInt(request.getParameter("reportingToId")));
        emp.setHod(hod);
        
        emp.setTotalholidays(30);
        emp.setHolidaybal(30);
        emp.setEmail(request.getParameter("email"));
        emp.setEmployeetype(request.getParameter("empType"));
        emp.setPassword(request.getParameter("password"));
        
        if(emp.getId()>0) {
        	hmDao.updateEmployee(emp);
        }else {
        	hmDao.addEmployee(emp);
        }
        	
        response.sendRedirect("employee?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        Integer id = Integer.parseInt(request.getParameter("id"));
        
    	List<Department> departments = iDepartment.getAllDepartments();
    	List<Role> roles = iRole.getAllRoles();
    	List<Employee> employees = hmDao.getAllEmployees();
    	List<String> empTypes = new ArrayList<String>();
    	empTypes.add("admin");
    	empTypes.add("staff");
    	
    	EmployeePojo employeepojo = new EmployeePojo();
    	employeepojo.setDepartments(departments);
    	employeepojo.setRoles(roles);
    	employeepojo.setEmployees(employees);
    	employeepojo.setEmpTypes(empTypes);
    	
        Employee emp = hmDao.getEmployee(id);
        employeepojo = modelToPojo(emp, employeepojo);
        request.setAttribute("employeepojo", employeepojo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeEdit.jsp");
        
        dispatcher.forward(request, response);

    }

    private void updateEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Employee emp = new Employee();
        
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setFirstname(request.getParameter("firstname"));
        emp.setLastname(request.getParameter("lastname"));
        
        Department dept = new Department();
        dept.setId(Integer.parseInt(request.getParameter("departmentid")));
        emp.setDepartment(dept);
        
        Role role = new Role();
        role.setId(Integer.parseInt(request.getParameter("roleId")));
        emp.setRole(role);

        Employee hod = new Employee();
        hod.setId(Integer.parseInt(request.getParameter("reportingToId")));
        emp.setHod(hod);
        
        emp.setTotalholidays(Integer.parseInt(request.getParameter("totalLeaves")));
        emp.setHolidaybal(Integer.parseInt(request.getParameter("holidayBal")));
        emp.setEmail(request.getParameter("email"));
        emp.setEmployeetype(request.getParameter("employeetype"));
        emp.setPassword(request.getParameter("password"));
        
        hmDao.updateEmployee(emp);
        response.sendRedirect("employee?action=list");
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       
    	int id = (int) Long.parseLong(request.getParameter("id"));

        Employee emp = new Employee();
        emp.setId(id);
        hmDao.deleteEmployee(id);
        response.sendRedirect("employee?action=list");
    }
    
    private Employee pojoToModel(Employee e, EmployeePojo pojo) {
    	e.setFirstname(pojo.getFirstName());
    	e.setLastname(pojo.getLastName());
    	e.setPassword(pojo.getPassword());
    	e.setEmail(pojo.getEmail());
    	e.setEmployeetype(pojo.getEmpType());
    	e.setId(pojo.getId());
    	
    	e.setHolidaybal(pojo.getHolidatybal());
    	e.setTotalholidays(pojo.getTotalholidays());
    	
    	e.setDepartment(iDepartment.getDepartment(pojo.getDepartmentId()));
    	e.setRole(iRole.getRole(pojo.getRoleId()));
    	e.setHod(hmDao.getEmployee(pojo.getReportingToId()));
    	
    	return e;
    }
    
    private EmployeePojo modelToPojo(Employee e, EmployeePojo pojo) {
    	
    	pojo.setFirstName(e.getFirstname());
    	pojo.setLastName(e.getLastname());
    	pojo.setEmail(e.getEmail());
    	pojo.setEmpType(e.getEmployeetype());
    	pojo.setDepartmentId(e.getDepartment().getId());
    	pojo.setRoleId(e.getRole().getId());
    	pojo.setReportingToId(e.getHod().getId());
    	pojo.setHolidatybal(e.getHolidaybal());
    	pojo.setTotalholidays(e.getTotalholidays());
    	pojo.setId(e.getId());
    	pojo.setPassword(e.getPassword());
    	return pojo;
    	
    };

}
