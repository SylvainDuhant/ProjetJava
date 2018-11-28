package be.duhant.projet;

import java.util.Date;

import javax.swing.DefaultListModel;

public class Player extends User {

	private int unit;
	private Date registerDate;
	
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
	public Player(int id, String password,String login, String email, String address, Date birthday, int unit, Date registerDate ) {
		super(id,password,login, email ,address ,birthday);
		this.unit = unit;
		this.registerDate = registerDate;
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
	
	public DefaultListModel<GameUser> getAllGameUser(){
		DAOGameUser daogu = new DAOGameUser();
		return daogu.getAll(this);
	}
	
	@Override
	public String toString() {
		return super.getLogin() ;
	}
}
