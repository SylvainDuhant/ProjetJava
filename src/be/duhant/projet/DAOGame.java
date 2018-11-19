package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
			return null;
		}
	}

	@Override
	public int add(Game obj) {
		try {
			String  sql = "SELECT id_game FROM game where namee ='"+obj.getName()+"' AND id_console =" + obj.getPlat().getID();
			Statement stmt = super.connection();
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				return -1;
			}
			else {
				int id = getID()+1;
				sql = "insert into GAME (id_game,id_console,price,namee,developers,editor) VALUES ("+ id + ","+ obj.getPlat().getID()+"," + obj.getUnit() +",'" + obj.getName() + "','"+ obj.getDevelopers() +"','" +obj.getEditor() +"')";
				stmt.executeQuery(sql);
				return id;
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
			String sql = "SELECT max(id_game) FROM game";
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				if(resultat.next()) {
					id = resultat.getInt(1);
					return id;
				}
				return 0;
			}
			return -1;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -1;
		}
	}
	public List<Game> getAllGames(){
		List<Game> list = new ArrayList<Game>();
		try {
			Statement stmt = super.connection();
			String sql = "select * from game";
			ResultSet res = stmt.executeQuery(sql);
			Platform plat;
			DAOPlatform dao = new DAOPlatform();
			while(res.next()) {
				plat = dao.Find(res.getInt(2));
				list.add(new Game(res.getInt(1),plat,res.getInt(3),res.getString(4),res.getString(5),res.getString(6)));
			}
			return list;
		}
		catch(Exception err){
			System.out.println(err);
			return null;
		}
	}
	
	public DefaultListModel<Game> getAll(){
		DefaultListModel<Game> lt = new DefaultListModel<Game>();
		Statement stmt = super.connection();
		String sql = "Select * from game";
		DAOPlatform daop = new DAOPlatform();
		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				lt.addElement(new Game(res.getInt(1), daop.Find(res.getInt(2)), res.getInt(3),res.getString(4),res.getString(5),res.getString(6))); 
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
			String sql = "DELETE FROM game WHERE id_game = " + id;		
			stmt.executeQuery(sql);
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
		}
	}
}
