package be.duhant.projet;

import java.util.Date;

public class Admin extends User{
	public Admin(String login,  Date birthday, String email, String address) {
		super(login, birthday, email,address);
	}
	public void AddGame() {
		//DAO
	}
	public void ModifyUnit() {
		//dao
	}
	public void DeleteGame() {
		//dao
	}
	public void AddConsole() {
		//dao
	}
	public void DeleteConsole() {
		//dao
	}
}
