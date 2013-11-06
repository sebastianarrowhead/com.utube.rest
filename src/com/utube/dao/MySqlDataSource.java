package com.utube.dao;

import javax.naming.*;
import javax.sql.*;

/**
 * This class returns the MySql database connect object from the
 * MySql instance
 * 
 * The method and variable in this class are static to save resources
 * You only need one instance of this class running.
 * 
 * This was explained in Part 3 of the Java Rest Tutorial Series on YouTube
 * 
 * @author 308tube
 *
 */
public class MySqlDataSource {

	private static DataSource mySqldb01Conn = null; //hold the database object
	private static Context context = null; //used to lookup the database connection in weblogic
	
	/**
	 * This is a public method that will return the 308tube database connection.
	 * 
	 * @return Database object
	 * @throws Exception
	 */
	public static DataSource fetchMySqldb01Conn() throws Exception {
		
		/**
		 * Check if database object is already defined...
		 * if true, then return the connection, no need to look it up again.
		 */
		if (mySqldb01Conn != null) {
			return mySqldb01Conn;
		}
		
		try {
			
			/**
			 * This only needs to run one time to get the database object.
			 * context is used to lookup the database object in weblogic
			 * Oracle308tube will hold the database object
			 */
			if (context == null) {
				context = new InitialContext();
			}
			
			mySqldb01Conn = (DataSource) context.lookup("mysqldb01jndi");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return mySqldb01Conn;
		
	}
	
}
