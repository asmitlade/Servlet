package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DateApp")
public class DateApp extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		Date dt = null;
		//set content type
		response.setContentType("text/html");
		// get response object
		pw = response.getWriter();
		//create Date class object
		dt = new Date();
		//write date to response object
		pw.println("<h1 style='color:red; text-align:center;'>Current Date and Time is :::"+dt+"</h1>");
		//close PrintWriter object
		pw.close();
	}//service
}//class
