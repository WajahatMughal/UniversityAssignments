package pojo;

import java.util.List;

import model.Employee;

public class HolidayPojo {

	private int id;
	
	private String fromDate;
	
	private String toDate;
	
	private String holidayDate;
	
	private String requestedDate;
	
	private String reason;
	
	private String noOfDays;
	
	private int assignTo;
	
	private List<Employee> employees;
	
	private int employeeId;
	
	private String employeeName;
	
	private String status;
	
	private Boolean isViolating = false;
	
	private List<String> violations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(int assignTo) {
		this.assignTo = assignTo;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Boolean getIsViolating() {
		return isViolating;
	}

	public void setIsViolating(Boolean isViolating) {
		this.isViolating = isViolating;
	}

	public List<String> getViolations() {
		return violations;
	}

	public void setViolations(List<String> violations) {
		this.violations = violations;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

}
