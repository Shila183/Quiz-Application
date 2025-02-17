package com.velocity.database.quizApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection {

	final String DB_Driver_Name = "oracle.jdbc.driver.OracleDriver";
	final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USERNAME = "system";
	final String PASSWORD = "system";
	Connection con = null;

	@Override
	public Connection databaseConnectivity() throws SQLException {

		try {
			Class.forName(DB_Driver_Name);
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return con;
	}

}
