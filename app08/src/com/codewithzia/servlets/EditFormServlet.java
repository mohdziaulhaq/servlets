package com.codewithzia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithzia.beans.Student;
import com.codewithzia.service.StudentService;

@WebServlet("/edit")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		
		StudentService stdService = new StudentService();
		Student std = stdService.getStudent(sid);
		
		if(std==null) {
			out.println("<html><body>");
			out.println("<h2 style='color: red;' align='center'>Code With Ziya</h2>");
			out.println("<h3 style='color: blue;' align='center'>Student Update Form</h3>");
			out.println("<h1 style='color: red;' align='center'>Student does'nt existed</h1>");
			out.println("<h3 align='center'>");
			out.println("<a href='./updateform.html'>|Student Update Form|</a>");
			out.println("</h3></body></html>");
		}else {
			out.println("<html><body>");
			out.println("<h2 style='color: red;' align='center'>Code With Ziya</h2>");
			out.println("<h3 style='color: blue;' align='center'>Student Update Form</h3>");
			out.println("<form method='POST' action='./update'>");
			out.println("<table align='center'>");
			out.println("<tr><td>Student ID</td><td>"+std.getSid()+"</td></tr>");
			out.println("<input type='hidden' name='sid' value='"+sid+"'/>");
			out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+std.getSname()+"'/></td></tr>");
			out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+std.getSaddr()+"'/></td></tr>");
			out.println("<tr><td><input type='submit' value='Update' /></td></tr>");
			out.println("</table></form></body></html>");
		}
		
	}

}
