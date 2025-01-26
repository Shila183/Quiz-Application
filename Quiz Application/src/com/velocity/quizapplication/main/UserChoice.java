package com.velocity.quizapplication.main;

import java.util.Scanner;

public class UserChoice {
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Question");
		String question =sc.next();
		
		System.out.println("Enter Option_a");
		String Option_a =sc.next();
		
		System.out.println("Enter Option_b");
		String Option_b =sc.next();
		
		System.out.println("Enter Option_c");
		String Option_c =sc.next();
		
		System.out.println("Enter Option_d");
		String Option_d =sc.next();
		
		sc.close();
	}
}
 