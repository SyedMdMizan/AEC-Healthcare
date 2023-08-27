package com.admin.servlet;

import java.io.IOException;


import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");   
   
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				session.setAttribute("adminobj", new User());
				response.sendRedirect("admin/index.jsp");
			}
			else {
				session.setAttribute("errorMsg", "invalid email or password");
				response.sendRedirect("admin_login.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
