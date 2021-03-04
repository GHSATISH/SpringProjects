package com.pk.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

	private static Connection con;
	private static PreparedStatement ps;
	
	public static Connection getConnection() throws IOException{
		
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul", "root", "root");
	
	   
	     
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (con != null)
					con.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}
			
			
			try {
				if (ps != null)
					ps.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}

		

	     }
		return con;
	  }
	}
