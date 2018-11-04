package be.duhant.projet;

import java.util.List;

public class Catalog {
	private List<GameUser> listGame;
	public Catalog(List<GameUser> listGame) {
		this.listGame = listGame;
	}
	public List<GameUser> getListGame(){
		return listGame;
	}
}