package com.pk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginPage extends HttpServlet {

	private static final String query = "SELECT * FROM USER_DETAILS WHERE USERNAME=? AND PASSWORD=?";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		String user = null;
		String password = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		user = req.getParameter("uname");
		password = req.getParameter("pass");

		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul", "root", "root");
			ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, password);
		//	RequestDispatcher rd = null;

			rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<center><h3 style='font-family:arial;'><a href='register.jsp'>Edit</a><br><br>");
				// rd.forward(req, res);
			} else {
				pw.println("<h1 style='color:red;text-align:center'>Invalid Credential Try Again !!!..</h1>");
				pw.println("<a href='index.jsp'>Home</a>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}
}
