package be.duhant.projet;

public class Game {
	private String name;
	private String developers;
	private String editor;
	private int unit;
	private Platform plat;
	
	public Game(String name, String developers, String editor, int unit, Platform plat) {
		this.name = name;
		this.developers = developers;
		this.editor = editor;
		this.unit = unit;
		this.plat = plat;
	}
	public String getName() {
		return name;
	}
	public String geDevelopers() {
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
