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
			String sql = "SELECT namee, developers, editor, price, id_console FROM game WHERE id_game ="+ ID;
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				
				boolean tmp = resultat.next();
				if(resultat.next()) {
					ga = new Game(resultat.getString(0),resultat.getString(1),resultat.getString(2),resultat.getInt(3), null);// DAOPlatform.getPlatformByID(resultat.getInt(4)));
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
		// TODO Auto-generated method stub
		return false;
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
