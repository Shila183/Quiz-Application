package com.velocity.admin.quizapplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;
import com.velocity.entity.quizApplication.Question;

public class QuestionHandlingImpl implements QuestionHandling {
	
	public void addQuestion(String ques, String opt_a,  String opt_b, String opt_c, String opt_d,  String c_ans, int marks) {
	
	Question question=new Question(ques, opt_a,  opt_b, opt_c, opt_d,  c_ans, marks);

	DatabaseConnectionImpl databaseConnectionImpl=new DatabaseConnectionImpl();
	Connection con=null;
	
	try {
		con=databaseConnectionImpl.databaseConnectivity();
		PreparedStatement ps=con.prepareStatement
				("insert into question(question,option_a,option_b,option_c,option_d,answer,marks)values(?,?,?,?,?,?,?)");
		
		ps.setString(1,question.getQuestion());
		ps.setString(2, question.getOption_a());
		ps.setString(3, question.getOption_b());
		ps.setString(4, question.getOption_c());
		ps.setString(5, question.getOption_d());
		ps.setString(6, question.getCorrectAnswer());
		ps.setInt(7, question.getMarks());
		
		ps.executeUpdate();
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
