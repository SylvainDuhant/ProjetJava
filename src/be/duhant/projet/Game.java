package be.duhant.projet;

public class Game {
	private int ID;
	private String name;
	private String developers;
	private String editor;
	private int unit;
	private Platform plat;
	
	public Game(int ID,Platform plat, int unit, String name, String developers, String editor ) {
		this.ID = ID;
		this.name = name;
		this.developers = developers;
		this.editor = editor;
		this.unit = unit;
		this.plat = plat;
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
}		
