package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DatabaseConnection {

	public Connection databaseConnectivity() throws SQLException;
	// public void addQuestion();
	
}
