package com.unite;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;




public class DbConnection {
	private String url_db =  "jdbc:mysql://localhost:3306/master_db";
	private String user_db = "root";
	private String pwd_db = "";
	private Connection conn;
	
	public DbConnection() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn = DriverManager.getConnection(url_db, user_db,pwd_db);
		}catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection Failed!");
            e.printStackTrace();
        }
 	}
	
	

	public Connection getConn() {
		return this.conn;
	}

	
	
	
	
	
	
	
 

 
}
