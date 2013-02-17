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
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	private Dal() {
        super();
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://akrogames.com/push?user=push&password=azf1234");
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
}
