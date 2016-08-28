package com.stanley.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection getConnection() throws SQLException {
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prayergroup", "root", "ilovecoding82@");

		return myConn;
	}
}
