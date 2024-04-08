package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the holiday database table.
 * 
 */
@Entity
@NamedQuery(name="Holiday.findAll", query="SELECT h FROM Holiday h")
public class Holiday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date holidaydate;

	private String reason;

	@Temporal(TemporalType.DATE)
	private Date requestdate;

	private String status;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="assignedto")
	private Employee hod;

	public Holiday() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHolidaydate() {
		return holidaydate;
	}

	public void setHolidaydate(Date holidaydate) {
		this.holidaydate = holidaydate;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRequestdate() {
		return this.requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getHod() {
		return hod;
	}

	public void setHod(Employee hod) {
		this.hod = hod;
	}

	public Holiday(int id, String reason, String status) {
		super();
		this.id = id;
		this.reason = reason;
		this.status = status;
	}
	

}