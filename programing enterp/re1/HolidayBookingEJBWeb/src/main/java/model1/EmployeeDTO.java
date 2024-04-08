package model1;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id = -1;

	private Department department;

	private String email;

	private long joinDate;

	private int numberOfAllowedLeaves;

	private String password;

	private Role role;
	
	private String address;

	private long dateOFBirth;

	private String name;

	private String phoneNumber;

	private String postCode;
	
	public EmployeeDTO(Department department, String email, long joinDate, int numberOfAllowedLeaves,
			String password, Role role,String address, long dateOFBirth, String name, String phoneNumber,
			String postCode) {
		super();
		this.department = department;
		this.email = email;
		this.joinDate = joinDate;
		this.numberOfAllowedLeaves = numberOfAllowedLeaves;
		this.password = password;
		this.role = role;
		this.address = address;
		this.dateOFBirth = dateOFBirth;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.postCode = postCode;
	}
	
	public EmployeeDTO(int id, Department department, String email, long joinDate, int numberOfAllowedLeaves,
			String password, Role role,String address, long dateOFBirth, String name, String phoneNumber,
			String postCode) {
		super();
		this.id = id;
		this.department = department;
		this.email = email;
		this.joinDate = joinDate;
		this.numberOfAllowedLeaves = numberOfAllowedLeaves;
		this.password = password;
		this.role = role;
		this.address = address;
		this.dateOFBirth = dateOFBirth;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.postCode = postCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}

	public int getNumberOfAllowedLeaves() {
		return numberOfAllowedLeaves;
	}

	public void setNumberOfAllowedLeaves(int numberOfAllowedLeaves) {
		this.numberOfAllowedLeaves = numberOfAllowedLeaves;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getDateOFBirth() {
		return dateOFBirth;
	}

	public void setDateOFBirth(long dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", department=" + department + ", role=" + role + ", name=" + name + "]";
	}

   
}
