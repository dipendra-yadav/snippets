package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDao {

	static {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}

		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	public Connection getMysqlConnection() {

		Connection con = null;
		try {
			
			//jdbc:mysql://HOST/DATABASE
				
			//con = DriverManager.getConnection("jdbc:mysql://HOST/DATABASE", "deependra", "root");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "deependra", "root");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

}
