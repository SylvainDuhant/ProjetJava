package be.duhant.projet;

import java.util.Date;

	public class GameUser {
		private Game ga;
		private Player pl;
		private  boolean available;
		private DAOGameUser dao = new DAOGameUser();
	
	public GameUser(Game ga,Player pl, boolean av) {
		this.ga = ga;
		this.pl = pl;
		available = av;
	}
	
	public Game getGame() {
		return ga;
	}
	public Player getPlayer() {
		return pl;
	}
	public boolean getAvailability() {
		return available;
	}
	public void setAvailability(boolean b) {
		available = b;
	}
	
	public int Create() {
		return dao.add(this);
	}
}