package com.pk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	public static final String UPDATE_EMPLOYEE_DETAILS="update emp_details set name=?,address=?,hobies=?,intrested=?";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		
		String name=null;
		String address =null;
		String hobies=null;
		String intrested=null;
		name=req.getParameter("name");
		address=req.getParameter("address");
		hobies=req.getParameter("hobies");
		intrested=req.getParameter("intrest");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul", "root", "root");
			ps=con.prepareStatement(UPDATE_EMPLOYEE_DETAILS);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(2, hobies);
			ps.setString(4, intrested);
		    rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("Record Inserted SucessFully");
				pw.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+""+rs.getString(4));
			}
			else
			{
				pw.println("Record Not Inserted");
			}
		    
			pw.close();
			rs.close();
			con.close();
			
		}
		catch(SQLException ce) {
			ce.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
