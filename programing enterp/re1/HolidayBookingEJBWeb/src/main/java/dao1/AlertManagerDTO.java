package dao1;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model1.Alert;

@Stateless
@LocalBean
public class AlertManagerDTO {
	@PersistenceContext(unitName="HolidayBookingEJBWeb")
	EntityManager em;
	
	public void createAlertMessage(String title,String message) {
		Alert alert = new Alert();
		alert.setMessage(message);
		alert.setTitle(title);
		alert.setViewed(false);
		em.persist(alert);
	}
	
	public List<Alert> getAlerts() {
		List<Alert> alert = em.createQuery("Select a from Alert a where a.viewed=0",Alert.class).getResultList(); 
		return alert;
	}
	
}
