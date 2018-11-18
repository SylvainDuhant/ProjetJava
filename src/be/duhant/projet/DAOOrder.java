package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DAOOrder extends DAO<Order>{

	@Override
	public int getID() {
		try {
			int id;
			String sql = "SELECT max(id_ordr) FROM ordr";
			Statement stmt = super.connection();
			if (stmt != null) {
				ResultSet resultat = stmt.executeQuery(sql);
				if(resultat.next()) {
					id = resultat.getInt(0);
					return id;
				}
			}
			return -1;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -1;
		}
	}

	@Override
	public int add(Order obj) {
		String sql;
		Statement stmt = super.connection();
		int id = getID()+1;
		try {
			sql = "insert into ordr values ("+id +","+obj.getPl().getID()+","+obj.getGa().getID()+","+ obj.getRegisterDate()+","+obj.getBeginDate()+","+obj.getEndDate()+","+obj.getAccepted() +")";
			stmt.executeQuery(sql);
			return 1;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return -2;
		}
		
	}

	@Override
	public Order Find(int id) {
		String sql;
		Statement stmt = super.connection();
		try {
			sql = "select * from ordr where id_ordr = "+ id + ")";
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				DAOUser daoP = new DAOUser();
				DAOGame daoG = new DAOGame();
				Player pa = (Player) daoP.Find(res.getInt(2));
				Game ga = daoG.Find(res.getInt(3));
				Order od = new Order(pa,ga,res.getDate(4),res.getDate(5),res.getDate(6),res.getInt(7) == 1); //pas de boolean dans sql developper 
				return od;
			}	
			return null;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
		
	}

}
