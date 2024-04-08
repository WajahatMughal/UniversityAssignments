package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao1.HolidayManagerDTO;
import model1.Dates;
import model1.EmployeeDTO;
import model1.HolidayDTO;
import model1.Status;

/**
 * Servlet implementation class HolidayRequest
 */
@WebServlet("/HolidayRequest")
public class HolidayRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HolidayManagerDTO hdDTO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidayRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO employee = (EmployeeDTO) httpSession.getAttribute("user");
		if (employee != null) {
	     request.getRequestDispatcher("HolidayRequest.jsp").forward(request, response);	
		} else {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  }
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(Boolean.TRUE);
		EmployeeDTO employee = (EmployeeDTO) httpSession.getAttribute("user");
		if (employee != null) {
			String toDateString = request.getParameter("todate");
			long toDateLong = Dates.toTimeStamp(toDateString);
			Date toDate = new Date(toDateLong);
			String fromDateString = request.getParameter("fromdate");
			long fromDateLong = Dates.toTimeStamp(fromDateString);
			Date fromDate = new Date(fromDateLong);
			String reason = request.getParameter("reason");
			HolidayDTO holiday = new HolidayDTO(fromDate,Dates.numberOFDays(fromDate, toDate), reason, Status.Pending,toDate);
			holiday.setEmployee(employee);
			hdDTO.applyForLeave(holiday);
			produceMessageForLeaveRequestAlert("leave request made by employee ID : "+  holiday.getEmployee().getId()+ " name : " + holiday.getEmployee().getName()
					+ " for reason : "+ holiday.getReason() + " from : "+ holiday.getFromDate().toString() +" to : " + holiday.getToDate().toString());
			response.getWriter().append("your leave request is submited");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
    private void produceMessageForLeaveRequestAlert(String message) {
    	try {
			Context jndiContext = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("java:/ConnectionFactory");
			Queue calculationQueue = (Queue) jndiContext.lookup("java:/jms/HolidayBookingQueue");
			Connection connect = factory.createConnection();
			Session session = connect.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer sender = session.createProducer(calculationQueue);
			MapMessage mapMessage = session.createMapMessage();
			mapMessage.setString("title", "HolidayRequest");
			mapMessage.setString("message", message);
			System.out.println("Sending message");
			sender.send(mapMessage);
			connect.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

}
