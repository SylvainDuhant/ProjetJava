package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;

public class DAOPlatform extends DAO<Platform>{
	@Override
	public Platform Find(int ID) {
		try {
			Platform plat;
			String sql = "SELECT name, release_date FROM console WHERE id_console = "+ ID;
		    Statement stmt = super.connection();
			ResultSet resultat = stmt.executeQuery(sql);
			if(resultat.next()) {
				plat = new Platform(resultat.getString(1), resultat.getDate(2));
				return plat;
			}
			return null;
		}
		catch(Exception err){
			System.out.println(err);
			return null;
		}
	}

	@Override
	public boolean add(Platform obj) {
		String sql = "";
		try {
			Statement stmt = super.connection();
			ResultSet resultat = stmt.executeQuery(sql);
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
