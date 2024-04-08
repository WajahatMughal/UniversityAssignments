package model1;

import java.io.Serializable;

public class EmployeeStatus implements Serializable {
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean Working = false;
      private EmployeeDTO employee;
	public Boolean getWorking() {
		return Working;
	}
	public void setWorking(Boolean working) {
		Working = working;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
      
}
