package com.Project.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
//	static Connection provideConnection() throws SQLException, ClassNotFoundException {
//		Connection conn=null;
//		//step-1: load the Driver class
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		//step-2
//		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
//		conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
//		return conn;
//	}


	public static Connection provideConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String url = "jdbc:mysql://localhost:3306/onlinebanking";
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
//		conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		
		try {
			conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
//			conn = DriverManager.getConnection(url,"root","King@7866");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
