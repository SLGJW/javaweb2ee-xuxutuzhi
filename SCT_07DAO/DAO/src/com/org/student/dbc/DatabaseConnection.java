package com.org.student.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
//	private static final String DBDRIVER = "org.h2.Driver";
//	private static final String DBURL = "jdbc:h2:E:/h2data/test";
//	private static final String DBUSER = "root";
//	private static final String DBPASSWORD = "123456";
	
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/ch?serverTimezone=UTC";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private Connection conn = null;
	public DatabaseConnection() throws Exception {
		Class.forName(DBDRIVER);
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() throws Exception {
		if (this.conn != null) {	
			this.conn.close();
		}
	}
}
