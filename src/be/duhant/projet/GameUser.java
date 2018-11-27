package be.duhant.projet;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
		int id = dao.add(this);
		List<Order> lt = Order.getAll();
		Iterator<Order> it = lt.iterator();
		if(available) {
			while(it.hasNext()) {
				if(it.next().getGa().equals(ga)){
					available = false;
					//le reste pour le cas d'une commande sur un jeu pas dispo
				}
			}
		}
		return id;
		
	}
	
	public void changeAvailability(boolean b) {
		dao.changeAvailability(b,this);
		this.available=b;
	}
	
	public void giveBack() {
		available = true;
		dao.changeAvailability(true, this);
	}
	
	public void rant() {
		available = false;
		dao.changeAvailability(false, this);
	}
	
	@Override
	public String toString() {
		return ga.toString();
	}
}