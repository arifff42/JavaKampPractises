package entities.concretes;

import entities.abstracts.Entity;

public class Auth implements Entity {

	//private int id;
	//private String firstName;
	//private String lastName;
	private String email;
	private String password;
	
	public Auth() {
		
	}
			
	public Auth(String email, String password) {

		this.email = email;
		this.password = password;
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
