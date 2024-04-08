package model1;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class User implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private  String email;
	
	@NotNull
    private  String password;
     
    public User() {	
    } 
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
