package model1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the leaveslog database table.
 * 
 */
@Entity
@NamedQuery(name="Leaveslog.findAll", query="SELECT l FROM Leaveslog l")
public class Leaveslog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private long date;

	private int leavesLeft;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EmployeesID")
	private Employee employee;

	public Leaveslog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDate() {
		return this.date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getLeavesLeft() {
		return this.leavesLeft;
	}

	public void setLeavesLeft(int leavesLeft) {
		this.leavesLeft = leavesLeft;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}