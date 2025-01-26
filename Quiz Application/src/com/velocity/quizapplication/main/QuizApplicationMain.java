package com.velocity.quizapplication.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.student.quizapplication.DatabaseConnectionImpl;
import com.velocity.student.quizapplication.QuestionHandlingImpl;

public class QuizApplicationMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("option 1- Student Registration"); // Shubham
		System.out.println("Option 2 - Student Login"); //// Shubham
		System.out.println("Option 3 - Display the list of questions"); // Shila
		System.out.println("Option 4 - Store Quiz result into database"); // Shila
		System.out.println("Option 5 - Display Quiz result"); // Rahul
		System.out.println("Option 6 - Display all students score as per ascending order");// Kunal
		System.out.println("Option 7 - Fetch student score by using id"); //Vipul
		System.out.println("Option 8 - Add question with 4 options into database"); //Vipul
		

		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();

		switch (choice) {

		case 1:
			System.out.println("You selected Student Registration");
			break;

		case 2:
			System.out.println("Your selected Student Login");
			
			break;
			
		case 3:
			System.out.println("Student Registration");
			break;
			
		case 4:
			System.out.println("Student Registration");
			break;
			
		case 5:
			System.out.println("Student Registration");
			break;
			
		case 6:
			System.out.println("Student Registration");
			break;
			
		case 7:
			System.out.println("Student Registration");
			break;
			
		case 8:
			System.out.println("Student Registration");
			getQuestion();
			break;
			
		default :
			System.out.println("Invalid Choice");
			break;
		}

	}

	public static void getQuestion() {
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<=3;i++) {
		
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
}
