package be.duhant.projet;

	public class GameUser {
		private int id = -1;
		private Game ga;
		private Player pl;
		private  boolean available;
		private DAOGameUser dao = new DAOGameUser();
	
	public GameUser(int id,Game ga,Player pl, boolean av) {
		this.id = id;
		this.ga = ga;
		this.pl = pl;
		available = av;
	}
	public int getID() {
		return id;
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
	
	public void changeAvailability(boolean b) {
		dao.changeAvailability(b,this);
		this.available=b;
	}
	
	@Override
	public String toString() {
		return ga.toString();
	}
}