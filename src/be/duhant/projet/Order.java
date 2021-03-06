package be.duhant.projet;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;

public class Order {
	private int ID;
	private Date registerDate;
	private Date beginDate;
	private Date endDate;
	private Boolean accepted;
	private Game ga;
	private GameUser gau = null;
	private Player pl;
	private static DAOOrder dao = new DAOOrder();
	
	public Order(int id,Player pl, Game ga, Date registerDate, Date beginDate, Date endDate, Boolean accepted) {
		this.ID = id;
		this.pl = pl;
		this.registerDate = registerDate;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.accepted = accepted;
		this.ga = ga;
	}
	
	public Order(int id,Player pl, Game ga, GameUser gau, Date registerDate, Date beginDate, Date endDate, Boolean accepted) {
		this.ID = id;
		this.pl = pl;
		this.registerDate = registerDate;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.accepted = accepted;
		this.ga = ga;
		this.gau = gau;
	}
	public Date getRegisterDate() {
		return registerDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public int getID() {
		return ID;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public Game getGa() {
		return ga;
	}

	public Player getPl() {
		return pl;
	}
	
	public GameUser getGau() {
		return gau;
	}
	public void create() {
		dao.add(this);
	}

	@Override
	public String toString() {
		return ga.getName() + "   " + ga.getPlat();
	}
	
	public static DefaultListModel<Order> getAll(Player pl) {
		return dao.getAllOrder(pl);
	}
	
	public void giveBack() {
		if(accepted) {
			accepted = false;
			endDate = new Date();
			gau.giveBack();
			dao.updateState(this);
		}
	}
	public static List<Order> findOrder(Game g) {
		return dao.findByGame(g);
	}
	
	public static List<Order>getAll(){
		return dao.getAllOrder();
	}
	
	public void UpdateOrder(GameUser gu) {
		dao.updateOrder(this,gu);
	}
	public static boolean findByGameUser(GameUser gu) {
		return dao.findByGameUser(gu);
	}
}
