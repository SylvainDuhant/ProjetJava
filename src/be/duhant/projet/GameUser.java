package be.duhant.projet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameUser {
		private int id = -1;
		private Game ga;
		private Player pl;
		private  boolean available;
		private DAOGameUser dao = new DAOGameUser();
	
	public GameUser(int id,Game ga,Player pl, boolean av) {
		this.id = id;
		this.ga = ga;
		this.pl = pl;
		available = av;
	}
	public int getID() {
		return id;
	}
	public Game getGame() {
		return ga;
	}
	public Player getPlayer() {
		return pl;
	}
	public boolean getAvailability() {
		return available;
	}
	public void setAvailability(boolean b) {
		available = b;
	}
	
	public int Create() {
		
		List<Order> lt = Order.getAll();
		Iterator<Order> it = lt.iterator();
		id = dao.add(this);
		if(available) {
					List<Order> conflict = Order.findOrder(ga);
					Iterator<Order> it2 = conflict.iterator();
					int a = 0;;
					if(conflict.size() > 0) {
						while(it2.hasNext()) {
							available = false;
							Order tmp = it2.next();
							if(a >= tmp.getPl().getUnit()) {
								it2.remove();
							}
							else {
								a = tmp.getPl().getUnit();
							}
						}
						if(conflict.size()==1) {
							dao.changeAvailability(false, this);
							it2 = conflict.iterator();
							it2.next().UpdateOrder(this);
						}
						else {
							it2 = conflict.iterator();
							Date dt = it2.next().getRegisterDate();
							while(it2.hasNext()) {
								if(it2.next().getRegisterDate().compareTo(dt) >= 0) {
									it2.remove();
								}
								else {
									dt = it2.next().getRegisterDate();
								}
							}
							if(conflict.size()==1) {
								dao.changeAvailability(false, this);
								it2 = conflict.iterator();
								it2.next().UpdateOrder(this);
							}
							else {
								it2 = conflict.iterator();
								dt = it2.next().getPl().getRegisterDate();
								while(it2.hasNext()) {
									if(it2.next().getPl().getRegisterDate().compareTo(dt) >= 0) {
										it2.remove();
									}
									else {
										dt = it2.next().getPl().getRegisterDate();
									}
									if(conflict.size()==1) {
										dao.changeAvailability(false, this);
										it2 = conflict.iterator();
										it2.next().UpdateOrder(this);
									}
									else {
										it2 = conflict.iterator();
										dt = it2.next().getPl().getBirthday();;
										while(it2.hasNext()) {
											if(it2.next().getPl().getBirthday().compareTo(dt) >= 0) {
												it2.remove();
											}
											else {
												dt = it2.next().getPl().getBirthday();
											}
											if(conflict.size()==1) {
												dao.changeAvailability(false, this);
												it2 = conflict.iterator();
												it2.next().UpdateOrder(this);
											}
											else {
												dao.changeAvailability(false, this);
												it2 = conflict.iterator();
												Random r = new Random();
												int result = r.nextInt(conflict.size());
												for(int i = 0;i<result-1;i++) {
													it2.next();
												}
												it2.next().UpdateOrder(this);
											}
										}
									}
								}
							}
						}
					}
				}
		return id;
		
	}
	
	public void changeAvailability(boolean b) {
		dao.changeAvailability(b,this);
		this.available=b;
	}
	
	public void giveBack() {
		available = true;
		dao.changeAvailability(true, this);
	}
	
	public void rant() {
		available = false;
		dao.changeAvailability(false, this);
	}
	
	@Override
	public String toString() {
		return ga.toString();
	}
}