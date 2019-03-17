package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VoteEligibiltyCheck")
public class VoteEligibiltyCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null, tage=null;
		int age=0;
		//get Writer
		pw = response.getWriter();
		//set content type
		response.setContentType("text/html");
		//get request parameter values
		name = request.getParameter("pname");
		tage = request.getParameter("page");
		age = Integer.parseInt(tage);
		// write request processing logic
		if(age>=18) {
			pw.println("<h1 style='color:green'>"+name+" you are eligible for voting</h1>");
		}
		else {
			pw.println("<h1 style='color:red'>"+name+" you are not eligible for voting,try after (18-age) years</h1>");
		}
		// add hyperlink
		pw.println("<a href='check_eligibility.html'><img src='home.png' alt='register'></a>");
		//close stream
		pw.close();
	}//doGet(-)
}//class
