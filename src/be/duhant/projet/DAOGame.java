package be.duhant.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DAOGame {
	
	/*
	private String name;
	private String developers;
	private String editor;remove
	private int unit;
	private Platform plat;
	 */
	public static Game getGameByID(int ID) {
		try {
			Game ga;
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    Connection co = ods.getConnection();
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection co = DriverManager.getConnection("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe" ,"Ora26", "b");
			*/
			String sql = "SELECT namee, developers, editor, price, id_console FROM game";// WHERE id_game ="+ ID;		
			Statement stmt = co.createStatement();
			ResultSet resultat = stmt.executeQuery(sql);
			
			boolean tmp = resultat.next();
			if(resultat.next()) {
				ga = new Game(resultat.getString(0),resultat.getString(1),resultat.getString(2),resultat.getInt(3), null);// DAOPlatform.getPlatformByID(resultat.getInt(4)));
				return ga;
			}
			System.out.println("Requête vide" + " " + tmp);
			return null;
		}
		catch(Exception err){
			System.out.println(err);
			return null;
		}
	}
}
