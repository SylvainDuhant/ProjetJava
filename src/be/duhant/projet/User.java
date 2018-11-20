package be.duhant.projet;

import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public abstract class User {
	private int id;
	private String login;
	private Date birthday;
	private String email;
	private String password;
	private String address;
	static DAOUser dao;
	
	public User(int id,String password,String login, String email, String address, Date birthday){
		this.id = id;
		this.password = password;
		this.login = login;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		dao = new DAOUser();
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
	public void SetID(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	
	public static User Find(int id) {
		return dao.Find(id);
	}
	public static int Login(String lg, String pw) {
		dao = new DAOUser();
		return dao.connect(lg, pw);
	}
}
