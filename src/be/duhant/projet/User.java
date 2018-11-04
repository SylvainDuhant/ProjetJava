package be.duhant.projet;

import java.util.Date;

public abstract class User {
	private String login;
	private Date birthday;
	private String email;
	//manque liste de jeux
	//private String password; not required, DAO will handle identification.
	private String address;
	
	public User(String login,  Date birthday, String email, String address ){
		this.login = login;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
	}
	
	public String getLogin() {
		return login;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
}
