package model1;

import java.io.Serializable;
import java.util.List;

public class LeaveRequest implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<String> constraints ;
  private HolidayDTO leave;
public List<String> getConstraints() {
	return constraints;
}
public void setConstraints(List<String> constraints) {
	this.constraints = constraints;
}
public HolidayDTO getLeave() {
	return leave;
}
public void setLeave(HolidayDTO leave) {
	this.leave = leave;
}
}
