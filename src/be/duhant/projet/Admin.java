package be.duhant.projet;

import java.util.Date;

public class Admin extends User{
	public Admin(int id, String password,String login, String email, String address, Date birthday ) {
		super(id,password,login, email ,address ,birthday);
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
