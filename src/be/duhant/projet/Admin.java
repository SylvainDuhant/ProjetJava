package be.duhant.projet;

import java.util.Date;

public class Admin extends User{
	public Admin(int id, String password,String login, String email, String address, Date birthday ) {
		super(id,password,login, email ,address ,birthday);
	}
}
