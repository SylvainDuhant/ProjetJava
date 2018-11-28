package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DAOGameUser extends DAO<GameUser>{

	@Override
	public GameUser Find(int id) {
		String sql;
		Statement stmt = super.connection();
		try {
			GameUser gu;
			sql = "select * from game_copy where id_copy = " + id;
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				DAOGame daoG = new DAOGame();
				Game ga = daoG.Find(res.getInt(2));
				DAOUser daoP = new DAOUser();
				Player pl = (Player) daoP.Find(res.getInt(3));
				boolean tmp;
				if(res.getInt(4) == 1) {
					tmp = true;
				}
				else {
					tmp = false;
				}
				gu = new GameUser(res.getInt(1),ga,pl,tmp);
				return gu;
			}
			return null;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

	@Override
	public int add(GameUser obj) {
		int id = getID()+1;
		int tmp;
		if(obj.getAvailability()) {
			tmp = 1;
		}
		else {
			tmp = 0;
		}
		String sql = "insert into game_copy values ("+id+","+obj.getGame().getID()+","+ obj.getPlayer().getID() +","+ tmp +")";
		Statement stmt = super.connection();
		try {
			stmt.executeQuery(sql);
			 
			return id;
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
			String sql = "SELECT max(id_copy) FROM game_copy";
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
	public List<GameUser> getAllGameUSer(){
		List<GameUser> li = new ArrayList<GameUser>();
		try {
			DAOGame daoG = new DAOGame();
			Game ga;
			DAOUser daoP = new DAOUser();
			Player pl;
			Statement stmt = super.connection();
			String sql = "select * from game_copy where AVAILABILITY = 1";
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				boolean tmp;
				if(res.getInt(4) == 1) {
					tmp = true;
				}
				else {
					tmp = false;
				}
				ga = daoG.Find(res.getInt(2));
				pl = (Player) daoP.Find(res.getInt(3));
				li.add(new GameUser(res.getInt(1),ga,pl,tmp));
			}
			 
			return li;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public DefaultListModel<GameUser> getAll(Player pl){
		DefaultListModel<GameUser> lt = new DefaultListModel<GameUser>();
		Statement stmt = super.connection();
		String sql = "Select * from game_copy where id_util = "+ pl.getID();
		try {
			ResultSet res = stmt.executeQuery(sql);
			DAOUser daop = new DAOUser();
			DAOGame daoG = new DAOGame();
			while(res.next()) {
				boolean tmp = false;
				if(res.getInt(4) == 1) {
					tmp = true;
				}
				lt.addElement(new GameUser(res.getInt(1),daoG.Find(res.getInt(2)),(Player)daop.Find(res.getInt(3)),tmp)); 
			}
			 
			return lt;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public void changeAvailability(boolean b,GameUser g) {
		Statement stmt = super.connection();
		int tmp = 0;
		if(b) {
			tmp = 1;
		}
		String sql = "update game_copy set availability = "+tmp+"where id_copy = " + g.getID();
		try {
			stmt.executeQuery(sql);
			stmt.close();
			 
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
		}
	}
}
