package com.org.mvcdemo.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/ch?serverTimezone=UTC";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private Connection conn = null; 
	public DatabaseConnection() throws Exception {
		// TODO Auto-generated constructor stub
		Class.forName(DBDRIVER);
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() {
		try {
			if (this.conn != null) {
				
				this.conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
