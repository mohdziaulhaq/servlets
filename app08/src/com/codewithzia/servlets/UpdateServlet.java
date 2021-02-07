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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		
		Student std =  new Student();
		std.setSid(sid);
		std.setSname(sname);
		std.setSaddr(saddr);
		
		StudentService stdService = new StudentService();
		String status = stdService.updateStudent(std);
		
		out.println("<html><body>");
		out.println("<h2 style='color: red;' align='center'>Code With Ziya</h2>");
		out.println("<h3 style='color: blue;' align='center'>Student Updation Status</h3>");
		out.println("<h1 style='color: red;' align='center'>");
		
		if(status.equals("success")) {
			out.println("Student Updation Success");
		}else {
			out.println("Student Updation Failure");
		}
		out.println("</h1>");
		out.println("<h3 align='center'>");
		out.println("<a href='./updateform.html'>|Student Updation Page|</a>");
		out.println("</h3></body></html>");		
	}
}
