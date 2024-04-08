package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_holiday database table.
 * 
 */
@Entity
@Table(name="tbl_holiday")
@NamedQuery(name="TblHoliday.findAll", query="SELECT t FROM TblHoliday t")
public class TblHoliday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="h_id")
	private int hId;

	@Column(name="h_edate")
	private String hEdate;

	@Column(name="h_sdate")
	private String hSdate;

	@Column(name="h_status")
	private String hStatus;

	//bi-directional many-to-one association to TblStaff
	@ManyToOne
	@JoinColumn(name="s_id")
	private TblStaff tblStaff;

	public TblHoliday() {
	}

	public int getHId() {
		return this.hId;
	}

	public void setHId(int hId) {
		this.hId = hId;
	}

	public String getHEdate() {
		return this.hEdate;
	}

	public void setHEdate(String hEdate) {
		this.hEdate = hEdate;
	}

	public String getHSdate() {
		return this.hSdate;
	}

	public void setHSdate(String hSdate) {
		this.hSdate = hSdate;
	}

	public String getHStatus() {
		return this.hStatus;
	}

	public void setHStatus(String hStatus) {
		this.hStatus = hStatus;
	}

	public TblStaff getTblStaff() {
		return this.tblStaff;
	}

	public void setTblStaff(TblStaff tblStaff) {
		this.tblStaff = tblStaff;
	}

}