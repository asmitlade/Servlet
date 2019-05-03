package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw = null;
		String ss = null;
		String  url = null;
		String engg = null;
		//get writer
		pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		ss = req.getParameter("ss");
		engg = req.getParameter("engg");
		if(engg.equals("google"))
			url = "https://www.google.com/search?q="+ss;
		else if(engg.equals("yahoo"))
			url = "https://in.search.yahoo.com/search?p="+ss;
		else if(engg.equals("bing"))
			url = "https://www.bing.com/search?q="+ss;
		else
			url = "https://www.ask.com/web?q="+ss;
		System.out.println("before Redirect...........");
		pw.println("before Redirect.............");
		res.sendRedirect(url);
		pw.println("After Redirect.............");
		System.out.println("After Redirect...........");
		RequestDispatcher rd = req.getRequestDispatcher("search.html");
		rd.include(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
