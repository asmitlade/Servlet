package com.mac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 PrintWriter pw = null;
    	 String country = null;
    	 String[] indiaCities = {"Delhi","Mumbai","Banglore","Hyderabad"};
    	 String[] pakCities = {"Karachi","Lahore","Faisalabad","Rawalpindi"};
    	 String[] usaCities = {"New York","Washinton DC","Chicago","Las Vegas"};
    	 String[] chinaCities = {"Shanghai","Taipei","Hong Kong","Beijing"};
    	 String[] austCities = {"Sydney","Melbourne","Brisbane","Perth"};
    	 pw = res.getWriter();
    	 //set content type
    	 res.setContentType("text/html");
    	 country = req.getParameter("country");
    	 if(country.equalsIgnoreCase("India"))
    		 pw.println("India Famous Cities ::"+Arrays.toString(indiaCities));
    	 else if(country.equalsIgnoreCase("Pakistan"))
    		 pw.println("Pakistan Famous Cities ::"+Arrays.toString(pakCities));
    	 else if(country.equalsIgnoreCase("USA"))
    		 pw.println("USA Famous Cities ::"+Arrays.toString(usaCities));
    	 else if(country.equalsIgnoreCase("China"))
    		 pw.println("China Famous Cities ::"+Arrays.toString(chinaCities));
    	 else
    		 pw.println("Australia Famous Cities ::"+Arrays.toString(austCities));
    	 //get hyperlink
    	 pw.println("<br><a href='http://localhost:2525/Servlet004-CountryWithCitiesApp/home.html'>home</a>");
    	 //close pw object
    	 pw.close();
     }

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
