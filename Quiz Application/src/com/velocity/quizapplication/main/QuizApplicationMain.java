package com.velocity.quizapplication.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.student.quizapplication.DatabaseConnectionImpl;

public class QuizApplicationMain {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your choice:");
		int choice=scanner.nextInt();
		
		switch(choice) {
		
		case 1:
			addQuestion();
			break;
			
		}
	
		
	}
	
	public static void addQuestion() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter question:");
		String question=scanner.next();
		
		System.out.println("Enter option a:");
		String option_a=scanner.next();
		
		System.out.println("Enter option b:");
		String option_b=scanner.next();
		
		System.out.println("Enter option c:");
		String option_c=scanner.next();
		
		System.out.println("Enter option d:");
		String option_d=scanner.next();
		
		System.out.println("Enter correct answer:");
		String answer=scanner.next();
		
		System.out.println("Enter marks:");
		int marks=scanner.nextInt();
		
		DatabaseConnectionImpl databaseConnectionImpl=new DatabaseConnectionImpl();
		Connection con=null;
		try {
			con=databaseConnectionImpl.databaseConnectivity();
			PreparedStatement ps=con.prepareStatement
					("insert into question(question,option_a,option_b,option_c,option_d,answer,marks)value(?,?,?,?,?,?,?)");
			
			ps.setString(1,question);
			ps.setString(2, option_a);
			ps.setString(3, option_b);
			ps.setString(4, option_c);
			ps.setString(5, option_d);
			ps.setString(6, answer);
			ps.setInt(7, marks);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		scanner.close();
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
