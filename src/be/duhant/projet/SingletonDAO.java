package be.duhant.projet;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import oracle.jdbc.pool.OracleDataSource;

public class SingletonDAO {
	private static boolean instanciated;
	private static SingletonDAO instance;
	private Statement stmt;
	private Connection co;
	
	private SingletonDAO() {
		try {
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    co = ods.getConnection();
		    stmt = co.createStatement();
		}catch(Exception err) {
			JOptionPane.showMessageDialog(null,err);
		}
	}
	
	public Statement UpdateConnection() {
		try {
			stmt.close();
			co.close();
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:Oracle:thin:@char-oracle11.condorcet.be:1521:xe");
		    ods.setUser("ORA26");
		    ods.setPassword("b");
		    co = ods.getConnection();
		    stmt = co.createStatement();
		    return stmt;
		}
		catch(Exception err){
			JOptionPane.showMessageDialog(null,err);
			return null;
		}
	}
	public static SingletonDAO instanciate(){
		if(!instanciated) {
			return new SingletonDAO();
		}
		else {
			instance.UpdateConnection();
			return instance;
		}
	}
	public Statement getStatement() {
		return stmt;
	}
	protected void finalize() {
		try {
			stmt.close();
			co.close();
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null,err);
		}
		
		
	}
}
