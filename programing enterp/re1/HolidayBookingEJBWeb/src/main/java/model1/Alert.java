package model1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Alert database table.
 * 
 */
@Entity
@NamedQuery(name="Alert.findAll", query="SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String message;

	private String title;

	private Boolean viewed;

	public Alert() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getViewed() {
		return this.viewed;
	}

	public void setViewed(Boolean viewed) {
		this.viewed = viewed;
	}

}