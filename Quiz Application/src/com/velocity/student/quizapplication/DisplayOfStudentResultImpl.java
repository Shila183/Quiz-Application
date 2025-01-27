package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;

public class DisplayOfStudentResultImpl {

	static DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
	static Connection con = null;
	static Scanner scanner = new Scanner(System.in);

	// Choice 5
	public static int student_score;

	public static void displayStudentResultbyUnPwd() {
		System.out.println("Enter User Name");
		String username = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();
		String correctDetails = StudentLoginImpl.checkUserRole(username, password);

		if (correctDetails.equalsIgnoreCase("student")) {

			try {
				con = databaseConnectionImpl.databaseConnectivity();

				String sql = "select student_score from student_result where student_username = ?";

				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					student_score = rs.getInt("student_score");
				}

				System.out.println("Your score is " + student_score);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("You entered Wrong cred or password/ You are an admin");
		}
	}

}
