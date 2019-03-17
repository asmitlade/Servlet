package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get PrintWriter object
		PrintWriter pw = response.getWriter();
		//set content type
		response.setContentType("text/xml");
		//write to response object
		pw.println("<table border='1' style='color:cyan'>");
		pw.println("<tr><td>asmit</td><td>Engineer</td><td>5045040</td></tr>");
		pw.println("<tr><td>mac</td><td>Clerk</td><td>767767</td></tr>");
		pw.println("<tr><td>machael</td><td>Manager</td><td>998877</td></tr>");
		pw.println("</table>");
		//close pw.object
		pw.close();
	}

}
