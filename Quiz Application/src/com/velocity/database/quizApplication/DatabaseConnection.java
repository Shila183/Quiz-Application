package com.velocity.database.quizApplication;
import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {

	public Connection databaseConnectivity() throws SQLException;

	
}
