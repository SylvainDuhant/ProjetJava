package be.duhant.projet;

import java.util.Date;

public class Platform {
	private String platformName;
	private Date releaseDate;
	public Platform(String platformName, Date releaseDate) {
		this.platformName = platformName;
		this.releaseDate = releaseDate;
	}
	public String getplatformName() {
		return platformName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
}
