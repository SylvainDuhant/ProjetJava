package be.duhant.projet;

import java.util.Date;

public class Order {
	Date registerDate;
	Date beginDate;
	Date endDate;
	Boolean accepted;
	Game ga;
	Player pl;
	
	public Order(Player pl, Game ga, Date registerDate, Date beginDate, Date endDate, Boolean accepted) {
		this.pl = pl;
		this.registerDate = registerDate;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.accepted = accepted;
		this.ga = ga;
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

	public Boolean getAccepted() {
		return accepted;
	}

	public Game getGa() {
		return ga;
	}

	public Player getPl() {
		return pl;
	}
}
