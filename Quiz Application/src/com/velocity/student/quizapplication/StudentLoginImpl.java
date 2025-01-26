package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.velocity.admin.quizapplication.AdminOperationsImpl;

public class StudentLoginImpl {
	
	
public static String checkUserRole(String username, String Password) {
		
		DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
		Connection con = null;
		String result = "";
	
		try {
			con = databaseConnectionImpl.databaseConnectivity();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from STUDENT");
			//boolean result = false;
			boolean iscredIdFound = false;
			
			while (rs.next()) {
				String user_name_from_db=rs.getString("STUDENT_USERNAME");
				String user_password_from_db=rs.getString("STUDENT_PASSWORD");
				String user_role_from_db=rs.getString("STUDENT_ROLE");
				
				if (username.equals(user_name_from_db) && Password.equals(user_password_from_db)) {
					
					if (user_role_from_db.equals("Admin")) {
						
						result="Admin";
						iscredIdFound=true;
						
					} else {
						result="student";
						iscredIdFound=true;
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


public static void studentlogin() {
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter user name ");
	String uname=scanner.next();	
	
	System.out.println("Enter user Password ");
	String pword=scanner.next();	
	
	String loginrole=checkUserRole(uname,pword);
	
	if (loginrole.equals("Student")) {
		
		System.out.println("Option 1 - Display the list of questions");
		System.out.println("Option 2 - Store Quiz result into database");
		System.out.println("Option 3 - Display Quiz result"); 		
		
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			break;
		
		case 2:
			
			break;
			
		case 3:
		
		break;
			
		}

		
	}else {
		
		System.out.println("Option 1 - Display all students score as per ascending order");
		System.out.println("Option 2 - Fetch student score by using id");
		System.out.println("Option 3 - Add question with 4 options into database");
		
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			break;
	
		case 2:
			AdminOperationsImpl.getStudentResultbyId();
			break;
			
		case 3:
			AdminOperationsImpl.addQuestion();
			break;
		}

		
	}
	
}


}
