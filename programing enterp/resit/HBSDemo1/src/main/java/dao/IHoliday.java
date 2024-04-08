package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Employee;
import model.Holiday;

@Local
public interface IHoliday {

	public List<Holiday> getAllHolidays();
	
	public List<Holiday> getAllHolidays(int empId);
	
	public List<Holiday> getHolidaysToApproveByHod(int hodId);
	
	public Long getHolidayCountByDateHodAndStatus(Date date, int hodId, String status);
	
	public Long getSrStaffHolidayCountByDateHodAndStatus(Date date, int hodId, String status, List<String> roles);
	
	public Holiday getHolidayById(int holidayId);
	
	public void updateHoliday(Holiday holiday);
	
	public List<Holiday> saveHoliday(Holiday holiday);
	
	public void deleteHoliday(int holidayId);
	
	public List<Holiday> saveHoliday(List<Holiday> holidays);
	
}
