package be.duhant.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DAOPlatform {
	static public Platform getPlatformByID(int ID) {
		try {
			Platform plat;
			String sql = "SELECT name, release_date FROM console WHERE id_console = "+ ID;
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    Connection co = ods.getConnection();
		    Statement stmt = co.createStatement();
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

}
