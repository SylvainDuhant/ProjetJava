package be.duhant.projet;

import java.util.Date;

public abstract class User {
	private int id;
	private String login;
	private Date birthday;
	private String email;
	//manque liste de jeux
	private String password;
	private String address;
	
	public User(int id,String password,String login, String email, String address, Date birthday){
		this.id = id;
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
	public int getID() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
