package com.mac.servlet;

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

@WebServlet("/dburl")
public class DBServlet extends HttpServlet {
	private static final String SEARCH_EMP = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE EMPNO = ?";
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public void init() throws ServletException {
		try {
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedSatement
			ps = con.prepareStatement(SEARCH_EMP);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//init()
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		int eno = 0;
		ResultSet rs = null;
		//get PrintWriter object
		pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//get input value from html
		eno = Integer.parseInt(req.getParameter("eno"));
		try {
			//set value to SQL query param
			ps.setInt(1,eno);
			//execute SQL query
			rs = ps.executeQuery();
			//process the result
			if(rs.next()) {
				pw.println("<br>Employee Number :::"+rs.getInt(1));
				pw.println("<br>Employee Name :::"+rs.getString(2));
				pw.println("<br>Employee Job :::"+rs.getString(3));
				pw.println("<br>Employee Salary :::"+rs.getFloat(4));
			}
			else {
				pw.println("<br>Employee Not Found");
			}
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet(-,-)

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

	@Override
	public void destroy() {
		//close JDBC con
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//destory()
}//class
