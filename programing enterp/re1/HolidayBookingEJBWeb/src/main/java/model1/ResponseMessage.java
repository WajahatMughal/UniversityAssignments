package model1;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean error;
	
	private String message;
	  
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
