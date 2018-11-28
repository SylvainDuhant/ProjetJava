package be.duhant.projet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
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
					id = resultat.getInt(1);
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
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
		try {
			int tmpb;
			if(obj.getAccepted()) {
				tmpb = 1;
			}
			else {
				tmpb = 0;
			}
			//sql = "insert into ordr values ("+id +","+obj.getPl().getID()+","+obj.getGa().getID()+","+ obj.getGau().getID() +","
			//+"TO_DATE('"+ d.format(obj.getRegisterDate())+"','DD/MM/YYYY'), TO_DATE('"+ d.format(obj.getBeginDate())+"','DD/MM/YYYY'), TO_DATE('"+ d.format(obj.getEndDate())+"','DD/MM/YYYY'),"+tmpb +")";
			
			
			sql = "insert into ordr values (" + id +","+obj.getPl().getID()+","+obj.getGa().getID()+",";
			if(obj.getGau() != null) {
				sql = sql+obj.getGau().getID()+",";
			}
			else {
				sql = sql+"null,";
			}
			sql = sql + "TO_DATE('"+ d.format(obj.getRegisterDate())+"','DD/MM/YYYY'),";
			if(obj.getBeginDate() != null) {
				sql = sql + "TO_DATE('"+ d.format(obj.getBeginDate())+"','DD/MM/YYYY'),";
			}
			else {
				sql = sql+"null,";
			}
			if(obj.getEndDate() != null) {
				sql = sql + "TO_DATE('"+ d.format(obj.getEndDate())+"','DD/MM/YYYY'),";
			}
			else {
				sql = sql+"null,";
			}
			sql = sql+tmpb+")";
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
				Order od = new Order(res.getInt(1),pa,ga,res.getDate(4),res.getDate(5),res.getDate(6),res.getInt(7) == 1); //pas de boolean dans sql developper
				 
				return od;
			}	
			return null;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
		
	}
	public DefaultListModel<Order> getAllOrder(Player pl){
		DefaultListModel<Order> lt = new DefaultListModel<Order>();
		Statement stmt = super.connection();
		String sql = "Select * from ordr where id_util ="+pl.getID();
		DAOGame daog = new DAOGame();
		DAOGameUser daogu = new DAOGameUser();
		
		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				lt.addElement(new Order(res.getInt(1),pl,daog.Find(res.getInt(3)),daogu.Find(res.getInt(4)),res.getDate(5),res.getDate(6),res.getDate(7),res.getInt(8) == 1));
			}
			 
			return lt;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	
	public List<Order> getAllOrder(){
		List<Order> lt = new ArrayList<Order>();
		Statement stmt = super.connection();
		String sql = "Select * from ordr";
		DAOGame daog = new DAOGame();
		DAOUser daou = new DAOUser();
		DAOGameUser daogu = new DAOGameUser();
		
		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				lt.add(new Order(res.getInt(1),(Player)daou.Find(res.getInt(2)),daog.Find(res.getInt(3)),daogu.Find(res.getInt(4)),res.getDate(5),res.getDate(6),res.getDate(7),res.getInt(8) == 1));
			}
			 
			return lt;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}
	public void updateState(Order od) {
		 SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
		 String sql ="Update ordr set  end_date =TO_DATE('"+d.format(new Date())+"', 'DD/MM/YYYY'), is_landed = 0";
		 Statement stmt = super.connection();
		 try {
			 stmt.executeQuery(sql);
			  
		 }
		 catch(Exception err) {
			 JOptionPane.showMessageDialog(null,err.getMessage());
		 }
	}
	public List<Order> findByGame(Game g){
		String sql = "select * from ordr where id_game = "+g.getID() + "and begin_date is null";
		Statement stmt = super.connection();
		try {
			ResultSet res = stmt.executeQuery(sql);
			List<Order> li = new ArrayList<Order>();
			DAOUser daou = new DAOUser();
			DAOGame daog = new DAOGame();
			while(res.next()) {
				boolean tmp = res.getInt(8) == 1;
				li.add(new Order(res.getInt(1),(Player)daou.Find(res.getInt(2)),daog.Find(res.getInt(3)),res.getDate(5),res.getDate(6),res.getDate(7),tmp));
			}
			 
			return li;
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return null;
		}
	}

	public void updateOrder(Order order,GameUser gu) {
		 SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
		String sql = "update ordr set id_game_copy ="+gu.getID()+", begin_date =TO_DATE('"+d.format(new Date())+"', 'DD/MM/YYYY'), is_landed = 1 where id_ordr="+order.getID();
		Statement stmt = super.connection();
		try {
			stmt.executeQuery(sql);
			DAOUser daou = new DAOUser();
			daou.UpdateUnitOrder(order, gu);
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
		}
		
	}
	public boolean findByGameUser(GameUser gu) {
		Statement stmt = super.connection();
		String sql = "select id_game_copy from ordr where id_game_copy ="+gu.getID() +"and end_date is null";
		try {
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,err.getMessage());
			return false;
		}
	}
}
