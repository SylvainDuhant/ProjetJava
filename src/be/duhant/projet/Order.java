package be.duhant.projet;

import java.util.Date;

public class Order {
	Date registerDate;
	Date beginDate;
	Date endDate;
	Boolean accepted;
	GameUser gu;
	
	public Order(Date registerDate, Date beginDate, Date endDate, Boolean accepted, GameUser gu) {
		this.registerDate = registerDate;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.accepted = accepted;
		this.gu = gu;
	}
}
