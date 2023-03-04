package com.admin.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");   
//        PrintWriter out=response.getWriter();
		
		HttpSession session = request.getSession();
		session.removeAttribute("adminobj");
		session.setAttribute("succMsg", "Admin Logout Successfull");
		response.sendRedirect("admin_login.jsp");
	}

}
