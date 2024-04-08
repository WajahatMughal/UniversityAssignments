package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HBSDTO;
import model.TblDepartment;

/**
 * Servlet implementation class HBSServlet
 */
@WebServlet("/HBSServlet")
public class HBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private HBSDTO hbsdto;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HBSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
			String param_action = request.getParameter("action");
			String tableStr = new String();
			
			
			
			switch(param_action) {
			case "showAllDepartment":
			{
				List<TblDepartment> dptlist = hbsdto.allDepartment();
				
				
				tableStr += "<table border='1'";
				tableStr += "<tr><td>ID</td><td>Title</td></tr>";
				for(int i = 0; i < dptlist.size(); i++)
				{
					tableStr += "<tr><td>" + String.valueOf(dptlist.get(i).getDId()) + 
							     "</td><td>" + dptlist.get(i).getDName() + "</td><tr>";
				}
				tableStr += "</table>";
			}
			break;
			case "insertStaff":
			{
				String fname = request.getParameter("fname");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String department = request.getParameter("department");
				String role = request.getParameter("role");
				String joindate = request.getParameter("join_date");
				
				
				 			
				hbsdto.insertStaff(fname,username,password,department,role,joindate);
				
				tableStr += "<br/><strong>Staff inserted</strong>";

			}
			break;
			case "showAllAuthors":
			{
				
			}
			break;
			case "insertAuthor":
			{
			}
			break;
			case "updateBookSimple":
			{
				
			}
			break;
			default:
				
				break;
		}
						
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Book Store App </title>");
			out.println("</head>");
			
			out.println("<body>");
			out.println(tableStr);
			out.println("</body>");
			out.println("</html>");
			out.close();
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
