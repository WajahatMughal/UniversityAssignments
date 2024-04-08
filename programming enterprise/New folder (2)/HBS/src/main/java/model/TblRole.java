package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_roles database table.
 * 
 */
@Entity
@Table(name="tbl_roles")
@NamedQuery(name="TblRole.findAll", query="SELECT t FROM TblRole t")
public class TblRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r_id")
	private int rId;

	@Column(name="r_name")
	private String rName;

	//bi-directional many-to-one association to TblStaff
	@OneToMany(mappedBy="tblRole")
	private List<TblStaff> tblStaffs;

	public TblRole() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public List<TblStaff> getTblStaffs() {
		return this.tblStaffs;
	}

	public void setTblStaffs(List<TblStaff> tblStaffs) {
		this.tblStaffs = tblStaffs;
	}

	public TblStaff addTblStaff(TblStaff tblStaff) {
		getTblStaffs().add(tblStaff);
		tblStaff.setTblRole(this);

		return tblStaff;
	}

	public TblStaff removeTblStaff(TblStaff tblStaff) {
		getTblStaffs().remove(tblStaff);
		tblStaff.setTblRole(null);

		return tblStaff;
	}

}