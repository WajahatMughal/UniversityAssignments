package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_staff database table.
 * 
 */
@Entity
@Table(name="tbl_staff")
@NamedQuery(name="TblStaff.findAll", query="SELECT t FROM TblStaff t")
public class TblStaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="s_id")
	private int sId;

	private String department;

	private String fname;

	@Column(name="is_admin")
	private int isAdmin;

	@Column(name="join_date")
	private String joinDate;

	@Column(name="leave_limit")
	private int leaveLimit;

	private String password;

	private String role;

	private String username;

	//bi-directional many-to-one association to TblHoliday
	@OneToMany(mappedBy="tblStaff")
	private List<TblHoliday> tblHolidays;

	//bi-directional many-to-one association to TblRole
	@ManyToOne
	@JoinColumn(name="r_id")
	private TblRole tblRole;

	//bi-directional many-to-one association to TblDepartment
	@ManyToOne
	@JoinColumn(name="d_id")
	private TblDepartment tblDepartment;

	public TblStaff() {
	}

	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getLeaveLimit() {
		return this.leaveLimit;
	}

	public void setLeaveLimit(int leaveLimit) {
		this.leaveLimit = leaveLimit;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<TblHoliday> getTblHolidays() {
		return this.tblHolidays;
	}

	public void setTblHolidays(List<TblHoliday> tblHolidays) {
		this.tblHolidays = tblHolidays;
	}

	public TblHoliday addTblHoliday(TblHoliday tblHoliday) {
		getTblHolidays().add(tblHoliday);
		tblHoliday.setTblStaff(this);

		return tblHoliday;
	}

	public TblHoliday removeTblHoliday(TblHoliday tblHoliday) {
		getTblHolidays().remove(tblHoliday);
		tblHoliday.setTblStaff(null);

		return tblHoliday;
	}

	public TblRole getTblRole() {
		return this.tblRole;
	}

	public void setTblRole(TblRole tblRole) {
		this.tblRole = tblRole;
	}

	public TblDepartment getTblDepartment() {
		return this.tblDepartment;
	}

	public void setTblDepartment(TblDepartment tblDepartment) {
		this.tblDepartment = tblDepartment;
	}

}