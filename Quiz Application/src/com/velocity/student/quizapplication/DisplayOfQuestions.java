package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;

public class DisplayOfQuestions {

	static int score = 0;

	static Scanner scanner = new Scanner(System.in);

	// option 3-Display the list of questions
	public int displayOfQuestions(String stud_username, int student_id, String student_firstname,
			String student_lastname) {

		DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
		Connection con = null;
		try {
			con = databaseConnectionImpl.databaseConnectivity();

			PreparedStatement ps = con
					.prepareStatement("select question,option_a,option_b,option_c,option_d,answer,marks from question");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("\n" + "Question: " + rs.getString(1));
				System.out.println("Marks: " + rs.getString(7));
				System.out.println("a. " + rs.getString(2));
				System.out.println("b. " + rs.getString(3));
				System.out.println("c. " + rs.getString(4));
				System.out.println("d. " + rs.getString(5) + "\n");
				String correctAnswer = rs.getString(6);

				boolean value = true;

				while (value == true) {

					System.out.println("Enter correct answer: ");
					String answer = scanner.next();

					if (answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d")) {
						if (correctAnswer.equals(answer)) {

							score++;

						}
						value = false;
					} else {
						try {
							throw new InvalidInputException("\nPlease enter the valid input");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						value = true;
					}
				}

			}
			setScoreInDB(score, stud_username, student_id, student_firstname, student_lastname);
			con.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}

	// Choice 4-Store Quiz result into database
	public static void setScoreInDB(int scoreOfStudent, String stud_username, int student_id, String student_firstname,
			String student_lastname) {

		DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
		Connection con = null;
		try {
			con = databaseConnectionImpl.databaseConnectivity();
			PreparedStatement ps = con.prepareStatement(
					"insert into student_result (student_username,student_score,student_id,student_firstname,student_lastname) values(?,?,?,?,?)");

			ps.setString(1, stud_username);
			ps.setInt(2, scoreOfStudent);
			ps.setInt(3, student_id);
			ps.setString(4, student_firstname);
			ps.setString(5, student_lastname);

			int i = ps.executeUpdate();
			System.out.println("Data is inserted into student_result......" + i);
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
