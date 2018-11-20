package be.duhant.projet;

import javax.swing.DefaultListModel;

public class Game {
	private int ID;
	private String name;
	private String developers;
	private String editor;
	private int unit;
	private Platform plat;
	private static DAOGame dao = new DAOGame();
	
	public Game(int ID,Platform plat, int unit, String name, String developers, String editor ) {
		this.ID = ID;
		this.name = name;
		this.developers = developers;
		this.editor = editor;
		this.unit = unit;
		this.plat = plat;
	}
	public Game (int id) {
		DAOGame u = new DAOGame();
		Game g = u.Find(id);
		this.ID = id;
		this.name = g.getName();
		this.developers = g.getDevelopers();
		this.editor = getEditor();
		this.unit = g.getUnit();
		this.plat = g.getPlat();
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDevelopers() {
		return developers;
	}
	public String getEditor() {
		return editor;
	}
	public int getUnit() {
		return unit;
	}
	public Platform getPlat() {
		return plat;
	}
	@Override
	public String toString() {
		return  name + "       " + plat.getplatformName();
	}
	
	public int add() {
		int res = dao.add(this);
		return res;
	}
	public void delete() {
		dao.delete(ID);
	}
	
	static public DefaultListModel<Game> getAll(){
		return dao.getAll();
	}
	static public DefaultListModel<Game> getAll(String nom,Platform plat){
		return dao.getAll(nom, plat);
	}
}		
