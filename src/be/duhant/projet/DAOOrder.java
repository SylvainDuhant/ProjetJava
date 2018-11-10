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
	public boolean add(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order Find(int id) {
		return null;
	}

}
