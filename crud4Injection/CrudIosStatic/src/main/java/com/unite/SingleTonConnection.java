package com.unite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTonConnection {
	
 
	
	private static Connection conn ;
	
	
	static {
		try {

			String url_db =  "jdbc:mysql://localhost:3306/master_db";
			  String user_db = "root";
			 String pwd_db = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url_db, user_db,pwd_db);
			}catch (ClassNotFoundException e) {
	            System.err.println("MySQL JDBC Driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.err.println("Connection Failed!");
	            e.printStackTrace();
	        }
	}
	
	
	public static Connection getConn() {
		return conn;
	}

}
