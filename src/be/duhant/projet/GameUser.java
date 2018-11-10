package be.duhant.projet;

import java.util.Date;

	public class GameUser {
		private Game ga;
		private Date disponibilityDate;
	
	public GameUser(Game ga, Date d) {
		this.ga = ga;
		disponibilityDate = d;
	}
	
	public Game getGame() {
		return ga;
	}
	public Date getDate() {
		return disponibilityDate;
	}
}