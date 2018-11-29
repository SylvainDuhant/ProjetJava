package be.duhant.projet;

import java.sql.Statement;

public abstract class DAO<T> {
	public abstract T Find(int id);
	public abstract int add(T obj);
	public abstract int getID();
	public Statement connection() {
			return SingletonDAO.instanciate().getStatement();
		}
	}
