package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MarriageApp")
public class MarriageApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null, tage=null, gender=null, vStatus=null;
		int age=0;
		//get Writer
		pw = response.getWriter();
		//set Content type
		response.setContentType("text/html");
		vStatus = request.getParameter("vflag");
		//check client side form validation are done or not
		if(vStatus.equals("no")) {
			//get values from URl parameters
			name = request.getParameter("name");
			tage = request.getParameter("age");		
			gender = request.getParameter("gender");
			if(name=="" || name.equals("") || name.length()==0) {
				pw.println("<span style='color:red'>Please enter Person Name</span>");
			}
			else if(tage=="" || tage.equals("") || tage.length()==0) {
				pw.println("<span style='color:red'>Please enter Person Age</span>");
			}
			else {
				try {
					//for server side validation
					age = Integer.parseInt(tage);
				}
				catch(NumberFormatException nfe) {
					pw.println("<span style='color:red'>Please enter Numeric number</span>");
				}
			}
		}
		else {
			// when clien side validation are done
			age = Integer.parseInt(tage);
		}
		//write b.logic
		if(age>=18 && gender.equals("female"))  
			pw.println("<h1 style='color:green;text-align:center'>Ms. "+name+" you are eligible for marriage</h1>");
		else if(age>=21 && gender.equals("male"))  
			pw.println("<h1 style='color:green;text-align:center'>Mr. "+name+" you are eligible for marriage</h1>");
		else 
			pw.println("<h1 style='color:red;text-align:center'>Mr/Ms. "+name+" you are not eligible for marriage</h1>");
			//add hyperlink
		pw.println("<a href='check_eligibility.html'><img src='home.png' alt='home'></a>");
		//close stream
		pw.close();
	}//doPost(-)
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}//class
