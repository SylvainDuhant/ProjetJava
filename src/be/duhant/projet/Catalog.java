package be.duhant.projet;

import java.util.Iterator;
import java.util.List;


public class Catalog {
	private static boolean instanciated = false;
	private List<GameUser> listGameUser;
	private List<Game> listGame;
	private static Catalog instance;
	public Catalog() {
		DAOGame daoG = new DAOGame();
		DAOGameUser daoGU = new DAOGameUser();
		listGameUser = daoGU.getAllGameUSer();
		listGame = daoG.getAllGames();
	}
	public List<Game> getListGame(){
		return listGame;
	}
	public List<GameUser> getListGameUser(){
		return listGameUser;
	}
	
	public static Catalog instianciate() {
		if (instanciated) {
			return instance;
		}
		else {
			instanciated = true;
			return new Catalog();			
		}
	}
	
	public GameUser searchFor(Game g) {
		Iterator<GameUser> it = listGameUser.iterator();
		GameUser ga;
		while (it.hasNext()) {
			ga = it.next();
			if(ga.getGame().equals(g)) {
				return ga;
			}
		}
		return null;
	}
}