package com.velocity.student.quizapplication;

public class Question {
	
	private String question;
	private String option_a;
	private String option_b;
	private String option_c;
	private String option_d;
	private String correctAnswer;
	private int marks;
	
	public Question(String question, String option_a, String option_b, String option_c, String option_d,
			String correctAnswer, int marks) {
		super();
		this.question = question;
		this.option_a = option_a;
		this.option_b = option_b;
		this.option_c = option_c;
		this.option_d = option_d;
		this.correctAnswer = correctAnswer;
		this.marks = marks;
	}
	
	public String getQuestion() {
		return question;
	}
	public String getOption_a() {
		return option_a;
	}
	public String getOption_b() {
		return option_b;
	}
	public String getOption_c() {
		return option_c;
	}
	public String getOption_d() {
		return option_d;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public int getMarks() {
		return marks;
	}
}
