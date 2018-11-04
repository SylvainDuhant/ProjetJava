package be.duhant.projet;

import java.util.Date;

public class Player extends User {
	private int unit;
	private Date registerDate;
	public Player(String login,  Date birthday, String email, String address, int unit, Date registerDate ) {
		super(login, birthday, email,address);
		this.unit = unit;
		this.registerDate = registerDate;
	}
	public void RayerJoueur() {
		//appel DAO
	}
}
