package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;

public class StudentLoginImpl {

	public static int student_id;
	public static String student_firstname;
	public static String student_lastname;
	static Scanner scanner = new Scanner(System.in);

	public static void studentlogin() {

		;

		DatabaseConnectionImpl db = new DatabaseConnectionImpl();

		Connection con = null;
		try {
			con = db.databaseConnectivity();

			System.out.println("Enter user name ");
			String uname = scanner.next();

			System.out.println("Enter user Password");
			String pword = scanner.next();

			String sql = "select * from student where student_username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Create a Student object and populate it with the data from the result set
				student_id = rs.getInt("student_id");
				student_firstname = rs.getString("student_firstname");
				student_lastname = rs.getString("student_lastname");
			}

			ps.executeUpdate();

			String loginrole = checkUserRole(uname, pword);
			if (loginrole.equalsIgnoreCase("student")) {

				DisplayOfQuestions doq = new DisplayOfQuestions();
				doq.displayOfQuestions(uname, student_id, student_firstname, student_lastname);

			} else {
				System.out.println("Access is denied for Admin");
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String checkUserRole(String username, String Password) {

		DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
		Connection con = null;
		String result = "";

		try {
			con = databaseConnectionImpl.databaseConnectivity();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from STUDENT");
			boolean iscredIdFound = false;

			while (rs.next()) {
				String user_name_from_db = rs.getString("STUDENT_USERNAME");
				String user_password_from_db = rs.getString("STUDENT_PASSWORD");
				String user_role_from_db = rs.getString("STUDENT_ROLE");

				if (username.equals(user_name_from_db) && Password.equals(user_password_from_db)) {

					if (user_role_from_db.equals("Admin")) {

						result = "Admin";
						iscredIdFound = true;

					} else {
						result = "student";
						iscredIdFound = true;
					}

				}
			}

			if (!iscredIdFound) {
				System.out.println("You entered Wrong cred or password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
