package model1;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String department;

	private String email;

	private long joinDate;

	private int numberOfAllowedLeaves;

	private String password;

	private String role;

	//bi-directional many-to-one association to Hoildayrequest
	@OneToMany(mappedBy="employee")
	private List<Hoildayrequest> hoildayrequests;

	//bi-directional many-to-one association to Leaveslog
	@OneToMany(mappedBy="employee")
	private List<Leaveslog> leaveslogs;

	//bi-directional one-to-one association to Person
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Person person;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}

	public int getNumberOfAllowedLeaves() {
		return this.numberOfAllowedLeaves;
	}

	public void setNumberOfAllowedLeaves(int numberOfAllowedLeaves) {
		this.numberOfAllowedLeaves = numberOfAllowedLeaves;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Hoildayrequest> getHoildayrequests() {
		return this.hoildayrequests;
	}

	public void setHoildayrequests(List<Hoildayrequest> hoildayrequests) {
		this.hoildayrequests = hoildayrequests;
	}

	public Hoildayrequest addHoildayrequest(Hoildayrequest hoildayrequest) {
		getHoildayrequests().add(hoildayrequest);
		hoildayrequest.setEmployee(this);

		return hoildayrequest;
	}

	public Hoildayrequest removeHoildayrequest(Hoildayrequest hoildayrequest) {
		getHoildayrequests().remove(hoildayrequest);
		hoildayrequest.setEmployee(null);

		return hoildayrequest;
	}

	public List<Leaveslog> getLeaveslogs() {
		return this.leaveslogs;
	}

	public void setLeaveslogs(List<Leaveslog> leaveslogs) {
		this.leaveslogs = leaveslogs;
	}

	public Leaveslog addLeaveslog(Leaveslog leaveslog) {
		getLeaveslogs().add(leaveslog);
		leaveslog.setEmployee(this);

		return leaveslog;
	}

	public Leaveslog removeLeaveslog(Leaveslog leaveslog) {
		getLeaveslogs().remove(leaveslog);
		leaveslog.setEmployee(null);

		return leaveslog;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
		person.setEmployee(this);
	}
	
	public EmployeeDTO convertEmployeeToDTO() {
    	Person person = this.getPerson();
		EmployeeDTO employee = new EmployeeDTO(this.getId(),
				               Department.valueOf(this.getDepartment()), 
				               this.getEmail(), 
				               this.getJoinDate(), 
				               this.getNumberOfAllowedLeaves(), 
				               this.getPassword(), 
				               Role.valueOf(this.getRole()), 
				               person.getAddress(),
				               person.getDateOFBirth(),
				               person.getName(), 
				               person.getPhoneNumber(), 
				               person.getPostCode());
		return employee;
	}

}