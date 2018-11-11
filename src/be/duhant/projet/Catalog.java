package be.duhant.projet;

import java.util.List;

public class Catalog {
	private List<GameUser> listGameUser;
	private List<Game> listGame;
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
}