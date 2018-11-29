package be.duhant.projet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
		id = dao.add(this);
		chckNeed();
		return id;
		
	}
	
	public void chckNeed() {
		if(available) {
			List<Order> conflict = Order.findOrder(ga);
			Iterator<Order> it2 = conflict.iterator();
			int a = 0;
			if(conflict.size() > 0) {
				while(it2.hasNext()) {
					Order tmp = it2.next();
					if(tmp.getPl().getUnit()>a) {
						a=tmp.getPl().getUnit();
					}
				}
				it2 = conflict.iterator();
				while(it2.hasNext()) {
					available = false;
					Order tmp = it2.next();
					if(a > tmp.getPl().getUnit()) {
						it2.remove();
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
					while(it2.hasNext()) { //get the biggest
						Order tmp = it2.next();
						if(tmp.getRegisterDate().compareTo(dt) <= 0) {
							dt=tmp.getRegisterDate();
						}
					}
					it2 = conflict.iterator();
					while(it2.hasNext()) { //delete the onces smaller than the biggest
						if(it2.next().getRegisterDate().compareTo(dt) >= 0) {
							it2.remove();
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
							Order tmp = it2.next();
							if(tmp.getPl().getRegisterDate().compareTo(dt) <= 0) {
								dt = tmp.getPl().getRegisterDate();
							}
						}
						it2 = conflict.iterator();
						while(it2.hasNext()) {
							if(it2.next().getPl().getRegisterDate().compareTo(dt) >= 0) {
								it2.remove();
							}
						}
						if(conflict.size()==1) {
							dao.changeAvailability(false, this);
							it2 = conflict.iterator();
							it2.next().UpdateOrder(this);
						}
						else {
							it2 = conflict.iterator();
							dt = it2.next().getPl().getBirthday();
							while(it2.hasNext()) {
								Order tmp = it2.next();
								if(tmp.getPl().getBirthday().compareTo(dt) <= 0) {
									dt = tmp.getPl().getBirthday();
								}
							}
							it2 = conflict.iterator();
							while(it2.hasNext()) {
								if(it2.next().getPl().getBirthday().compareTo(dt) >= 0) {
									it2.remove();
								}
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
	
	public void changeAvailability(boolean b) {
		dao.changeAvailability(b,this);
		this.available=b;
	}
	
	public void giveBack() {
		available = true;
		dao.changeAvailability(true, this);
		chckNeed();
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