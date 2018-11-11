package be.duhant.projet;

import java.util.Date;

	public class GameUser {
		private Game ga;
		private Player pl;
		private Date disponibilityDate;
	
	public GameUser(Game ga,Player pl, Date d) {
		this.ga = ga;
		this.pl = pl;
		disponibilityDate = d;
	}
	
	public Game getGame() {
		return ga;
	}
	public Player getPlayer() {
		return pl;
	}
	public Date getDate() {
		return disponibilityDate;
	}
}