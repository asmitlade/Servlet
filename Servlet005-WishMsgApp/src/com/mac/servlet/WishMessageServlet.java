package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WishMessageServlet")
public class WishMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		Calendar cal = null;
		int hour = 0;
		pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		cal = Calendar.getInstance();
		hour = cal.get(Calendar.HOUR_OF_DAY);
		if(hour<12)
			pw.println("<h1 style='color:red;text-aglin:center'>Good Morning.....</h1>");
		else if(hour<17)
			pw.println("<h1 style='color:red;text-aglin:center'>Good Afternoon.....</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:red;text-aglin:center'>Good Evening.....</h1>");
		else 
			pw.println("<h1 style='color:red;text-aglin:center'>Good Night.....</h1>");
		//close pw object
		pw.close();
	}
}
