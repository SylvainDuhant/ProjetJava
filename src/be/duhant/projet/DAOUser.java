package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DAOUser extends DAO<User>{

	@Override
	public User Find(int id) {
		Statement stmt = super.connection();
		User u;
		String sql = "SELECT * FROM util u inner join admini a on u.id_util = a.id_util where a.id_util = " + id;
		try {
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				u = new Admin(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5),res.getDate(6));
				return u;
			}
			else {
				sql = "select * from util u inner join player p on u.id_util = p.id_util where u.id_util = " + id;
				res = stmt.executeQuery(sql);
				if(res.next()) {
					u = new Player(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5),res.getDate(6),res.getInt(8),res.getDate(9));
					return u;
				}
				return null;
			}
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

	@Override
	public int add(User obj) {
		try {
			Statement stmt = super.connection();
			int id = getID()+1;
			String sql = "select id_util FROM util where login='"+obj.getLogin()+"'";
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
			ResultSet exist = stmt.executeQuery(sql);
				if(!exist.next()) {				
				sql = "INSERT INTO util VALUES ("+id+",'"+ obj.getPassword() + "','" + obj.getLogin() +"','"+ obj.getEmail() + "','" + obj.getAddress()+ "',TO_DATE('"+d.format(obj.getBirthday()) +"', 'DD/MM/YYYY'))";
				stmt.executeQuery(sql);
				if(obj instanceof Player) {
					Player tmp = (Player) obj;
					sql = "INSERT INTO player VALUES ("+id+","+tmp.getUnit()+",TO_DATE('"+ d.format(tmp.getRegisterDate()) +"', 'DD/MM/YYYY'))";
					stmt.executeQuery(sql);
					return id;
				}
				else {
					sql =  "INSERT INTO admini values("+id+")";
				}
			}
				return -1;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -2;
		}
		
	}

	@Override
	public int getID() {
		Statement stmt = super.connection();
		String sql = "Select max(id_util) FROM util";
		try {
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				return res.getInt(1);
			}
			return -1;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -1;
			
		}
		
	}
	
	public int connect(String login, String password) {
		Statement stmt = super.connection();
		String sql = "SELECT id_util from util where login = '"+ login + "' AND password = '"+password+"'";
		try {
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				return res.getInt(1);
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
	
	public DefaultListModel<Player> getAll(){
		DefaultListModel<Player> list = new DefaultListModel<Player>();
		try {
			Statement stmt = super.connection();
			String sql = "select * from util u inner join player p on p.id_util = u.id_util";
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				list.addElement(new Player(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getDate(6),res.getInt(8),res.getDate(9)));
			}
			return list;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public Player updateUnit(Player pl, int unit) {
		String sql = "update player set unit = "+ unit + " where id_util = " + pl.getID();
		Statement stmt = super.connection();
		try {
			stmt.executeQuery(sql);
			pl.setUnit(unit);
			return pl;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public int deletePlayer(Player pl) {
		String sql = "delete player where id_util = "+pl.getID();
		Statement stmt = super.connection();
		try {
			stmt.executeQuery(sql);
			sql = "delete util where id_util = " + pl.getID();
			stmt.executeQuery(sql);
			return 1;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -2;
		}
		
	}

}
