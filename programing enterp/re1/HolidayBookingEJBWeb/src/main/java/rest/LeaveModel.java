package rest;

import java.io.Serializable;

public class LeaveModel implements Serializable {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
   private int employeeID;
   private String fromDate;
   private String toDate;
   private String reason;
   
   public LeaveModel() {
   }
   
   
    public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
}
