package com.velocity.quizapplication.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.velocity.database.quizApplication.DatabaseConnectionImpl;

public class Userchoice {


		static int id=101;
		public static void main(String[] args) {
			
			DatabaseConnectionImpl databaseConnectionImpl = new DatabaseConnectionImpl();
			Connection con = null;
			try {
				con = databaseConnectionImpl.databaseConnectivity();

				PreparedStatement ps = con.prepareStatement("select * from student");
				ResultSet rs = ps.executeQuery();
				List<Integer> listOfId=new ArrayList<Integer>();
				while(rs.next()) {
					listOfId.add(rs.getInt(1));
				}
				boolean value=true;
				while(value) {
					if(listOfId.contains(id)) {
						id++;
						value=true;
					}else {
						// data insert
						value=false;
					}
				}	
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
}

