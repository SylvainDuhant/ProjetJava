package be.duhant.projet;

import java.util.Date;

import javax.swing.DefaultListModel;

public class Platform {
	private String platformName;
	private Date releaseDate;
	private int ID;
	private static DAOPlatform dao = new DAOPlatform();
	public Platform(int ID, String platformName, Date releaseDate) {
		this.ID = ID;
		this.platformName = platformName;
		this.releaseDate = releaseDate;
	}
	public String getplatformName() {
		return platformName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public int getID() {
		return ID;
	}
	@Override
	public String toString() {
		return platformName;
	}
	
	public void delete() {
		dao.delete(ID);
	}
	public static DefaultListModel<Platform> getALL(){
		return dao.getAll();
	}
	public int Create() {
		return dao.add(this);
	}
}
