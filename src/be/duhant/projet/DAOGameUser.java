package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOGameUser extends DAO<GameUser>{

	@Override
	public GameUser Find(int id) {
		String sql;
		Statement stmt = super.connection();
		try {
			GameUser gu;
			sql = "select * from game_copy where ig_copy = " + id +")";
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				DAOGame daoG = new DAOGame();
				Game ga = daoG.Find(res.getInt(2));
				DAOUser daoP = new DAOUser();
				Player pl = (Player) daoP.Find(res.getInt(3));
				gu = new GameUser(ga,pl,res.getDate(4));
				return gu;
			}
			JOptionPane.showMessageDialog(null,"l'exemplaire recherché n'existe pas");
			return null;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

	@Override
	public boolean add(GameUser obj) {
		int id = getID()+1;
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
		String sql = "insert into game_copy values ("+id+","+obj.getGame().getID()+","+ d.format(new Date()) +")";
		Statement stmt = super.connection();
		try {
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				return true;
			}
			return false;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return false;
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
					id = resultat.getInt(0);
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
	public List<GameUser> getAllGameUSer(){
		List<GameUser> li = new ArrayList<GameUser>();
		try {
			DAOGame daoG = new DAOGame();
			Game ga;
			DAOUser daoP = new DAOUser();
			Player pl;
			Statement stmt = super.connection();
			String sql = "select * from game_copy";
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				ga = daoG.Find(res.getInt(2));
				pl = (Player) daoP.Find(res.getInt(3));
				li.add(new GameUser(ga,pl,res.getDate(4)));
			}
			return li;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

}
