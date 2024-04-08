package model1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	private String address;

	private long dateOFBirth;

	private String name;

	private String phoneNumber;

	private String postCode;

	//bidirectional many-to-one association to Employee
    @OneToOne
    @MapsId
    @JoinColumn(name = "EmployeeID")
    private Employee employee;
    

	public Person() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getDateOFBirth() {
		return this.dateOFBirth;
	}

	public void setDateOFBirth(long dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}