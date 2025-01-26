package com.velocity.student.quizapplication;

import java.sql.SQLException;

public class StudentRegistrationImpl implements StudentRegistration{
	DatabaseConnectionImpl db=new DatabaseConnectionImpl();
	
	@Override
	public void addStudentRegistration() {
		
		try {
			db.databaseConnectivity();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
