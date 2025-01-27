package com.velocity.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;
import com.velocity.entity.quizApplication.Student;

public class StudentRegistrationImpl implements StudentRegistration {

	static Scanner scanner = new Scanner(System.in);
	static int student_id = 101;

	public static void addStudent() {

		System.out.println("Enter student first Name:");
		String first_name = scanner.next();

		System.out.println("Enter student last name:");
		String last_name = scanner.next();

		System.out.println("Enter username:");
		String username = scanner.next();

		System.out.println("Enter password:");
		String password = scanner.next();

		System.out.println("Enter city :");
		String city = scanner.next();

		System.out.println("Enter mail Id:");
		String email_Id = scanner.next();

		System.out.println("Enter mobile number:");
		String number = scanner.next();

		DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
		Connection con = null;
		try {
			con = databaseConnectionImpl.databaseConnectivity();

			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();

			List<Integer> listOfId = new ArrayList<Integer>();

			while (rs.next()) {
				listOfId.add(rs.getInt(1));
			}

			boolean value = true;
			while (value) {
				if (listOfId.contains(student_id)) {
					student_id++;
					value = true;
				} else {
					StudentRegistrationImpl sri = new StudentRegistrationImpl();
					Student student = new Student();
					student.setStudent_id(student_id);
					student.setFirstName(first_name);
					student.setLastName(last_name);
					student.setUserName(username);
					student.setPassword(password);
					student.setCity(city);
					student.setMail_id(email_Id);
					student.setMobileNumber(number);
					student.setStudentRole("student");

					sri.addStudentRegistration(student);
					System.out.println("data inserted");
					value = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addStudentRegistration(Student student) {

		DatabaseConnectionImpl db = new DatabaseConnectionImpl();

		Connection con = null;
		try {
			con = db.databaseConnectivity();

			String sql = "insert into student (student_id,student_firstname, student_lastname, student_mobileno, student_emailid, studnet_city, student_username, student_password, student_role) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getStudent_id());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			ps.setString(4, student.getMobileNumber());
			ps.setString(5, student.getMail_id());
			ps.setString(6, student.getCity());
			ps.setString(7, student.getUserName());
			ps.setString(8, student.getPassword());
			ps.setString(9, student.getStudentRole());
			ps.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
