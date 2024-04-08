package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import model1.LeaveRequest;
import model1.HolidayDTO;
import model1.Role;
import model1.Status;

/**
 * Servlet implementation class LeaveRequest
 */
@WebServlet("/LeaveRequest/*")
public class LeaveRequestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HolidayManagerDTO hdDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequestList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO admin = (EmployeeDTO) httpSession.getAttribute("user");
		if (admin.getRole() == Role.Admin) {
			List<HolidayDTO> requestList = hdDTO.listOFLeavePendingLeaveRequest();
			List<LeaveRequest> list = new ArrayList<LeaveRequest>();
			for (HolidayDTO leave : requestList) {
				LeaveRequest leaveRequest = new LeaveRequest();
				List<String> constraints = hdDTO.contrantsCheckFor(leave);
				leaveRequest.setConstraints(constraints);
				leaveRequest.setLeave(leave);
				list.add(leaveRequest);
			}
			request.setAttribute("requestlist", list);
			request.getRequestDispatcher("LeaveRequest.jsp").forward(request, response);	 
		} else {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String value = request.getPathInfo();
		   value = value.substring(1);
		   String[] values = value.split("_"); 
		   int action = Integer.parseInt(values[0]);
		   int requestID = Integer.parseInt(values[1]);
		   if ((requestID != 0)) {
			   HolidayDTO holiday = hdDTO.getLeaveRequestBy(requestID); 
			   if (action == 1) {
				   holiday.setStatus(Status.Accept);
			   } else {
				   holiday.setStatus(Status.Reject);
			   }
			   hdDTO.updateStatusRequest(holiday);
		   }
		   response.sendRedirect(request.getContextPath()+"/LeaveRequest");
	}

}
