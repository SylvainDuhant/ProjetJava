package be.duhant.projet;

import java.sql.Connection;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public abstract class DAO<T> {
	public abstract T Find(int id);
	public abstract boolean add(T obj);
	public abstract int getID();
	public Statement connection() {
		try {
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    Connection co = ods.getConnection();
		    Statement stmt = co.createStatement();
		    return stmt;
		}
		catch(Exception err){
			System.out.println(err);
			return null;
		}
	}
}
