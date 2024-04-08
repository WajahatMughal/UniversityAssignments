package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_department database table.
 * 
 */
@Entity
@Table(name="tbl_department")
@NamedQuery(name="TblDepartment.findAll", query="SELECT t FROM TblDepartment t")
public class TblDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d_id")
	private int dId;

	@Column(name="d_name")
	private String dName;

	//bi-directional many-to-one association to TblStaff
	@OneToMany(mappedBy="tblDepartment")
	private List<TblStaff> tblStaffs;

	public TblDepartment() {
	}

	public int getDId() {
		return this.dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	public String getDName() {
		return this.dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

	public List<TblStaff> getTblStaffs() {
		return this.tblStaffs;
	}

	public void setTblStaffs(List<TblStaff> tblStaffs) {
		this.tblStaffs = tblStaffs;
	}

	public TblStaff addTblStaff(TblStaff tblStaff) {
		getTblStaffs().add(tblStaff);
		tblStaff.setTblDepartment(this);

		return tblStaff;
	}

	public TblStaff removeTblStaff(TblStaff tblStaff) {
		getTblStaffs().remove(tblStaff);
		tblStaff.setTblDepartment(null);

		return tblStaff;
	}

}