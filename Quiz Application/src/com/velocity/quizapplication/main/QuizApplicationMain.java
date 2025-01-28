package com.velocity.quizapplication.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.velocity.admin.quizapplication.AdminOperationsImpl;
import com.velocity.student.quizapplication.DisplayOfStudentResultImpl;
import com.velocity.student.quizapplication.StudentLoginImpl;
import com.velocity.student.quizapplication.StudentRegistrationImpl;

public class QuizApplicationMain {
	static {
		System.out.println("************* WELCOME TO QUIZ *************\n");
	}
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		System.out.println("option 1- Student Registration"); // Shubham
		System.out.println("Option 2 - Student Login"); //// Shubham
		System.out.println("Option 3 - Display the list of questions"); // Shila
		System.out.println("Option 4 - Store Quiz result into database"); // Shila
		System.out.println("Option 5 - Display Quiz result"); // Rahul
		System.out.println("Option 6 - Display all students score as per ascending order");// Kunal
		System.out.println("Option 7 - Fetch student score by using id"); // Vipul
		System.out.println("Option 8 - Add question with 4 options into database"); // Vipul
		System.out.println("\n--------------------------------------------------------------------------------\n");
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();

		switch (choice) {

		case 1:
			System.out.println("You selected Student Registration");
			StudentRegistrationImpl.addStudent();
			break;

		case 2:
			System.out.println("You selected Student Login");
			StudentLoginImpl.studentlogin();
			break;

		case 3:

			System.out.println("** Your selected to attempt quiz questions **" + "\n");
			StudentLoginImpl.studentlogin();
			break;

		case 4:
			System.out.println("First give quiz and then stored it in database");
			StudentLoginImpl.studentlogin();

			break;

		case 5:
			System.out.println("Quiz result");
			DisplayOfStudentResultImpl.displayStudentResultbyUnPwd();
			break;

		case 6:
			System.out.println("Display all results based on ascending order");
			System.out.println("This is Admin Operation");
			AdminOperationsImpl.getStudentResult();
			break;

		case 7:
			System.out.println("Display result based on student ID");
			System.out.println("This is a Admin Operation");
			AdminOperationsImpl.getStudentResultbyId();
			break;

		case 8:
			System.out.println("Add your question");
			System.out.println("This is Admin Operation");
			AdminOperationsImpl.addQuestion();
			break;

		default:
			System.out.println("Invalid Choice");
			break;
		}

	}

}
