package be.duhant.projet;

import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Player extends User {
	@Override
	public String toString() {
		return super.getLogin() ;
	}
	private int unit;
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	private Date registerDate;
	public Player(int id, String password,String login, String email, String address, Date birthday, int unit, Date registerDate ) {
		super(id,password,login, email ,address ,birthday);
		this.unit = unit;
		this.registerDate = registerDate;
	}
	public void RayerJoueur() {
		//appel DAO
	}
	
	public Player ModifyUnit(int newUnit) {
		 return dao.updateUnit(this, newUnit);
	}
	
	public void delete() {
			dao.deletePlayer(this);
		}
	public static DefaultListModel<Player> getALL(){
		return dao.getAll();
	}
	public int Create() {
		return dao.add(this);
	}
}
