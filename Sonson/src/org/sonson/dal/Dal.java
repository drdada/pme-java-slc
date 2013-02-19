package org.sonson.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton couche DAL
 * @author Matt
 *
 */
public final class Dal {
	private static volatile Dal instance = null;
	
	final String host = "mysql://akrogames.com";
	final String db = "push";
	final String username = "push";
	final String password = "azf1234";
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	private Dal() {
        super();
        
        try {
			this.connexion();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
	public final static Dal getInstance() {
        if (Dal.instance == null) {
           synchronized(Dal.class) {
             if (Dal.instance == null) {
            	 Dal.instance = new Dal();
             }
           }
        }
        return Dal.instance;
    }
	
	private void connexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:"+host+"/"+db+"?user="+username+"&password="+password);
	}
	
	public ResultSet getResult(String sql) throws SQLException {
		ResultSet resultat;
		Statement statement = connect.createStatement(
		ResultSet.TYPE_FORWARD_ONLY,
		ResultSet.CONCUR_READ_ONLY);
		
		return resultat = statement.executeQuery(sql);
	}
	
	public void update(String sql) throws SQLException {
		this.statement = connect.createStatement();
		this.statement.executeUpdate(sql);
	}
	
	public void insert(String sql) throws SQLException {
		this.statement = connect.createStatement();
		this.statement.executeUpdate(sql);
	}
	
	public void finalize() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			System.out.println("ERREUR DE DECONNEXION A LA BASE");
		}
	}
}
