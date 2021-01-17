package com.codewithzia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("****Servlet Loading****");
	}
	
	public WelcomeServlet() {
		System.out.println("****Servlet Instantiation****");
	}
	@Override
	public void init() {
		System.out.println("****Servlet Initialization****");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("****Request Processing****");
	}

	@Override
	public void destroy() {
		System.out.println("****Servlet Deinstantiation****");
	}
}
