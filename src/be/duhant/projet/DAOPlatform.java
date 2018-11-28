package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DAOPlatform extends DAO<Platform>{
	@Override
	public Platform Find(int ID) {
		try {
			Platform plat;
			String sql = "SELECT * FROM console WHERE id_console = "+ ID;
		    Statement stmt = super.connection();
			ResultSet resultat = stmt.executeQuery(sql);
			if(resultat.next()) {
				plat = new Platform(resultat.getInt(1),resultat.getString(2), resultat.getDate(3));
				return plat;
			}
			return null;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

	@Override
	public int add(Platform obj) {
		int id = getID()+1;
		String sql;
		Statement stmt = super.connection();
		try {
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
			sql = "SELECT id_console from console where NAME = '" + obj.getplatformName() +"'";
			ResultSet res = stmt.executeQuery(sql);
			if(!res.next()) {
				sql = "INSERT INTO CONSOLE VALUES ("+ id + ",'" + obj.getplatformName() + "',TO_DATE('"+  d.format(obj.getReleaseDate())+"','DD/MM/YYYY'))";
				stmt.executeQuery(sql);
				return id;
			}
			else {
				return -1;
			}
			
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -2;
		}

	}
	@Override
	public int getID() {
		try {
			int id;
			String sql = "SELECT max(id_console) FROM console";
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				if(resultat.next()) {
					id = resultat.getInt(1);
					return id;
				}
				return 1;
			}
			return -1;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,"ici " +err.getMessage());
			return -1;
		}
	}
	
	public DefaultListModel<Platform> getAll(){
		DefaultListModel<Platform> lt = new DefaultListModel<Platform>();
		Statement stmt = super.connection();
		String sql = "Select * from console";
		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				lt.addElement(new Platform(res.getInt(1),res.getString(2), res.getDate(3))); 
			}
			return lt;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public void delete(int id) {
		Statement stmt = super.connection();
		try {
			String sql = "DELETE FROM console WHERE id_console = " + id;		
			stmt.executeQuery(sql);
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
		}
	}

}
