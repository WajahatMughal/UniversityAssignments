package model1;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the hoildayrequest database table.
 * 
 */
@Entity
@NamedQuery(name="Hoildayrequest.findAll", query="SELECT h FROM Hoildayrequest h")
public class Hoildayrequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private long fromDate;

	private int numberOfDate;

	private String reason;
	
	@Column(name ="Status")
	private String status;

	private long toDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EmployeeID")
	private Employee employee;

	public Hoildayrequest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(long fromDate) {
		this.fromDate = fromDate;
	}

	public int getNumberOfDate() {
		return this.numberOfDate;
	}

	public void setNumberOfDate(int numberOfDate) {
		this.numberOfDate = numberOfDate;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getToDate() {
		return this.toDate;
	}

	public void setToDate(long toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public HolidayDTO convertToDTOfromholidayRequest() {
		HolidayDTO holiday = new HolidayDTO(new Date(this.getFromDate()), 
				                            this.getNumberOfDate(), 
				                            this.getReason(), 
				                            Status.valueOf(this.status),
				                            new Date(this.getToDate()));
		holiday.setId(this.getId());
		holiday.setEmployee(this.employee.convertEmployeeToDTO());
		return holiday;
	}
	
	
}