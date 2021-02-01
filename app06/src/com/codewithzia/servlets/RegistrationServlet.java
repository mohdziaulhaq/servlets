package com.codewithzia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithzia.service.UserService;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		String umobile = request.getParameter("umobile");
		
		UserService userService = new UserService();
		String status = userService.registration(uname, upwd, uemail, umobile);
		
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<br><br><br><br>");
		out.println("<h1 style='color: red;' align='center'>");
		if(status.equals("existed")) {
			out.println("User Existed Already");
		}
		if(status.equals("success")) {
			out.println("User Registration Success");
		}
		if(status.equals("failue")) {
			out.println("User Registration Failure");
		}
		out.println("</h1></body></html>");
		
		
	}

}
