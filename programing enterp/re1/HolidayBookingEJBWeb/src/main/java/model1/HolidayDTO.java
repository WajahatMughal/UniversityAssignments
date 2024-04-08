package model1;

import java.io.Serializable;
import java.sql.Date;

public class HolidayDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id = -1;
	
	private Date fromDate;

	private int numberOfDate;

	private String reason;

	private Status status;

	private Date toDate;
	
	private EmployeeDTO employee;
	
	public HolidayDTO(Date fromDate,int numberOfDate,String reason,Status status,Date toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.numberOfDate = numberOfDate;
		this.reason = reason;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public int getNumberOfDate() {
		return numberOfDate;
	}

	public void setNumberOfDate(int numberOfDate) {
		this.numberOfDate = numberOfDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
		
}
