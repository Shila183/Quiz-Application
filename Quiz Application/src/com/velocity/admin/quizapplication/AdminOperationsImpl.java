package com.velocity.admin.quizapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;
import com.velocity.student.quizapplication.StudentLoginImpl;

public class AdminOperationsImpl {
	
	static DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
	static Connection con = null;
	static Scanner scanner = new Scanner(System.in);
	
	//Choice 7 implementation class
	public static void getStudentResultbyId() {
		System.out.println("Enter User Name");
		String user_name_from_user=scanner.next();
		System.out.println("Enter Password");
		String password_from_user=scanner.next();
		String correctDetails=StudentLoginImpl.checkUserRole(user_name_from_user,password_from_user );
		
		if (correctDetails.equalsIgnoreCase("Admin")) {
			
			System.out.println("Enter Student Id");
			int student_id=scanner.nextInt();
			AdminOperationsImpl.fetchStudentScore(student_id);
		}
	}
	
	public static void getStudentResult() {
		System.out.println("Enter User Name");
		String user_name_from_user=scanner.next();
		System.out.println("Enter Password");
		String password_from_user=scanner.next();
		String correctDetails=StudentLoginImpl.checkUserRole(user_name_from_user,password_from_user );
		
		if (correctDetails.equalsIgnoreCase("Admin")) {
			AdminOperationsImpl.fetchStudentScoreall();
		}
	}
	
	//Choice 8 implementation class
	public static void addQuestion() {
		
			System.out.println("Enter User Name");
			String user_name_from_user=scanner.next();
			System.out.println("Enter Password");
			String password_from_user=scanner.next();
			String correctDetails=StudentLoginImpl.checkUserRole(user_name_from_user,password_from_user );
			
			if (correctDetails.equalsIgnoreCase("Admin")) {
				scanner.nextLine(); 
		
				System.out.println("Enter question:");
				String question = scanner.nextLine();
				
				System.out.println("Enter option a:");
				String option_a = scanner.nextLine();
	
				System.out.println("Enter option b:");
				String option_b = scanner.nextLine();
	
				System.out.println("Enter option c:");
				String option_c = scanner.nextLine();
	
				System.out.println("Enter option d:");
				String option_d = scanner.nextLine();
	
				System.out.println("Enter correct answer:");
				String answer = scanner.nextLine();
	
				System.out.println("Enter marks:");
				int marks = scanner.nextInt();
	
				QuestionHandlingImpl questionHandlingImpl = new QuestionHandlingImpl();
				questionHandlingImpl.addQuestion(question, option_a, option_b, option_c, option_d, answer, marks);
				System.out.println("Data inserted successfully");
			}

		}
	

	public static void fetchStudentScore(int student_id) {

		try {
			con = databaseConnectionImpl.databaseConnectivity();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from STUDENT_RESULT");
			boolean isIdFound = false;
			
			while (rs.next()) {
				
				int stdIdFromDatabase = rs.getInt("STUDENT_ID");
				int sdtScore = rs.getInt("STUDENT_SCORE");
				
				if (student_id==stdIdFromDatabase) {
				
				System.out.println("Student Id>> " + stdIdFromDatabase);
				System.out.println("Score is>> " + sdtScore);
				isIdFound = true;
				break;
				} 
			}
			
			if (!isIdFound) { 
		           System.out.println("You entered an invalid ID");
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	};
	//Choice 6 method
	public static void fetchStudentScoreall() {

		try {
			con = databaseConnectionImpl.databaseConnectivity();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from STUDENT_RESULT order by Student_score ASC");
			//boolean isIdFound = false;
			
			while (rs.next()) {
				
				String stdfirstname = rs.getString("student_firstname");
				String stdlastname = rs.getString("student_lastname");
				int sdtScore = rs.getInt("student_score");
				
				System.out.println("First name>> " + stdfirstname);
				System.out.println("Last name>> " + stdlastname);
				System.out.println("Score is>> " + sdtScore);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	};
	
	
}
