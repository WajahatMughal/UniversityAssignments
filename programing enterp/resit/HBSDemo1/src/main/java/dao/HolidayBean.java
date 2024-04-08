package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import model.Holiday;

/**
 * Session Bean implementation class EmployeeDTO
 */
@Stateless
public class HolidayBean implements IHoliday{

	@PersistenceContext
	private EntityManager entityManager;
	
    public HolidayBean() {	
        
    }
    
    public List<Holiday> getAllHolidays() {
    	List<Holiday> Holidays = entityManager.createNamedQuery("Holiday.findAll", Holiday.class).getResultList();
    	
    	return Holidays;
           
    }
    
    public List<Holiday> getAllHolidays(int empId) {
    	List<Holiday> results = entityManager.createQuery("SELECT t FROM Holiday t where t.employee.id = :value1")
                .setParameter("value1", empId).getResultList();
        
        return results;
           
    }
    
    public List<Holiday> saveHoliday(List<Holiday> holidays) {
    	for(Holiday h : holidays)
    		entityManager.persist(h);
    	
    	return getAllHolidays(holidays.get(0).getEmployee().getId());
           
    }
    
    public List<Holiday> getHolidaysToApproveByHod(int hodId) {
    	List<Holiday> results = entityManager.createQuery("SELECT h FROM Holiday h where h.hod.id = :hodId and h.status = 'RAISED'"
    			+ "order by h.employee.holidaybal desc", Holiday.class)
                .setParameter("hodId", hodId).getResultList();
        
        return results;
    }
    
    public List<Holiday> getHolidaysByHodAndStatus(int hodId, String status) {
    	List<Holiday> results = entityManager.createQuery("SELECT h FROM Holiday h where h.hod.id = :hodId and h.status = :status", Holiday.class)
                .setParameter("hodId", hodId).getResultList();
        
        return results;
    }
    
    public Long getHolidayCountByDateHodAndStatus(Date date, int hodId, String status) {
    	Long count = entityManager.createQuery("SELECT count(1) FROM Holiday h where h.hod.id = :hodId and h.status = :status "
    			+ "and holidaydate = :date", Long.class)
    			.setParameter("date", date, TemporalType.DATE).setParameter("hodId", hodId)
    			.setParameter("status", status).getSingleResult();
    	return count;
    }
    
    public Long getSrStaffHolidayCountByDateHodAndStatus(Date date, int hodId, String status, List<String> roles) {
    	Long count = entityManager.createQuery("SELECT count(1) FROM Holiday h where h.hod.id = :hodId and h.status = :status "
    			+ "and holidaydate = :date and h.employee.role.name in (:roles)", Long.class)
    			.setParameter("date", date, TemporalType.DATE).setParameter("hodId", hodId)
    			.setParameter("status", status).setParameter("roles", roles).getSingleResult();
    	return count;
    }
    
    public void updateHoliday(Holiday holiday) {
    	Holiday holi = entityManager.find(Holiday.class, holiday.getId());
    	holi.setStatus(holiday.getStatus());
    	entityManager.merge(holi);
   }
    
    public List<Holiday> saveHoliday(Holiday holiday) {
    	entityManager.persist(holiday);
    	
    	return getAllHolidays(holiday.getEmployee().getId());
           
    }
    
    public void deleteHoliday(int holidayId) {
    	Holiday holiday = entityManager.find(Holiday.class, holidayId);
    	entityManager.remove(holiday);
    }
    
    public Holiday getHolidayById(int holidayId) {
    	return entityManager.find(Holiday.class, holidayId);
    }
    
}
