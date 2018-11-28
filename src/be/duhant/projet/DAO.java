package be.duhant.projet;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import oracle.jdbc.pool.OracleDataSource;

public abstract class DAO<T> {
	public abstract T Find(int id);
	public abstract int add(T obj);
	public abstract int getID();
	public Statement connection() {
		try {
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    Connection co = ods.getConnection();
		    return co.createStatement();
		}catch(Exception err) {
			JOptionPane.showMessageDialog(null,err);
			return null;
		}
		
	}
}
