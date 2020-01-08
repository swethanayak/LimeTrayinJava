package com.deloitte.limetray.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.deloitte.limetray.model.Registration;

public class RegistrationDAO {
	
	public static Connection connectToDB() {
		Connection connection = null;
		try {// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

}

	public static void adduser(Registration obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
		
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("insert into Registration values(?,?,?,?,?)");
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, obj.getUserid());
			stmt.setString(3, obj.getPassword());
			stmt.setLong(4, obj.getPhonenumber());
			stmt.setString(5, obj.getEmailid());
			// Execute SQL query
			int affectedrows = stmt.executeUpdate();
			System.out.println("Affected Rows = "+affectedrows);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static ArrayList<Registration> displayuser() {
		ArrayList<Registration> registrationList = new ArrayList<Registration>();
		// TODO Auto-generated method stub
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("select * from registration");
			
			// Execute SQL query
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Registration obj=new Registration();
				obj.setUsername(rs.getString(1));
				obj.setUserid(rs.getString(2));
				obj.setPassword(rs.getString(3));
				obj.setPhonenumber(rs.getLong(4));
				obj.setEmailid(rs.getString(5));
				registrationList.add(obj);
			}
	
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationList;
	}

	public static boolean signinuser(String userid,String password) {
		boolean flag = false;
		// TODO Auto-generated method stub
		try {
			
			Connection con = connectToDB();
			//Create Statement
			
			PreparedStatement stmt=con.prepareStatement("select * from registration where userid=? and password=?");
			stmt.setString(1,userid);
			stmt.setString(2, password);
			// Execute SQL query
			int affectedrows = stmt.executeUpdate();
			System.out.println("Affected Rows = "+affectedrows);
			if (affectedrows>=1)
				return flag=true;
	
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
	
	
	
}
