package org.sonson.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Singleton couche DAL
 * @author Matt
 *
 */
public final class Dal {
	private static volatile Dal instance = null;
	// A voir pour voklatile sur Connection
	private static volatile Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	private Dal() {
        super();
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
