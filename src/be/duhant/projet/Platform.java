package be.duhant.projet;

import java.util.Date;

public class Platform {
	private String platformName;
	private Date releaseDate;
	private int ID;
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
}
