package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;

public class DAOGame extends DAO<Game> {
	
	/*
	private String name;
	private String developers;
	private String editor;remove
	private int unit;
	private Platform plat;
	 */
	public Game Find(int ID) {
		try {
			Game ga;
			String sql = "SELECT * FROM game WHERE id_game ="+ ID;
			DAOPlatform dao = new DAOPlatform();
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				boolean tmp = resultat.next();
				if(resultat.next()) {
					Platform plat = dao.Find(resultat.getInt(2));
					ga = new Game(resultat.getInt(1),plat,resultat.getInt(3),resultat.getString(4),resultat.getString(5),resultat.getString(6));
					return ga;
				}
				System.out.println("Requête vide" + " " + tmp);
				return null;
			}
			return null;
		}
		catch(Exception err){
			System.out.println(err);
			return null;
		}
	}

	@Override
	public boolean add(Game obj) {
		try {
			int id = getID()+1;
			String sql = "insert into GAME (id_game,id_console,price,namee,developers,editor) VALUES ("+ id + ","+ obj.getPlat().getID()+"," + obj.getUnit() +"," + obj.getName() + ","+ obj.getDevelopers() +"," +obj.getEditor() +")";
			Statement stmt = super.connection();
			stmt.executeQuery(sql);
			return true;
		}
		catch(Exception err) {
			System.out.println(err);
			return false;
		}
	}

	@Override
	public int getID() {
		try {
			int id;
			String sql = "SELECT max(id_game) FROM game";
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				if(resultat.next()) {
					id = resultat.getInt(0);// DAOPlatform.getPlatformByID(resultat.getInt(4)));
					return id;
				}
				return 0;
			}
			return -1;
		}
		catch(Exception err){
			System.out.println(err);
			return -1;
		}
	}
}
