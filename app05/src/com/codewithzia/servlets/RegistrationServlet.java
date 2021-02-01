package com.codewithzia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int eno = Integer.parseInt(request.getParameter("eno"));
			String ename = request.getParameter("ename");
			float esal =Float.parseFloat(request.getParameter("esal"));
			String eaddr = request.getParameter("eaddr");
			
			out.println("<html><body>");
			out.println("<h2 style='color: red;' align='center'>Wipro Limited</h2>");
			out.println("<h3 style='color: blue;' align='center'>User Registration Details</h3>");
			out.println("<table border='1' align='center'>");
			out.println("<tr><td>Employee Number</td><td>"+eno+"</td></tr>");
			out.println("<tr><td>Employee Name</td><td>"+ename+"</td></tr>");
			out.println("<tr><td>Employee Salary</td><td>"+esal+"</td></tr>");
			out.println("<tr><td>Employee Address</td><td>"+eaddr+"</td></tr>");
			out.println("</table>");
			out.println("<h3 align='center'>");
			out.println("<a href='./registrationform.html'>|Registration Form|</a>");
			out.println("</h3></body</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}