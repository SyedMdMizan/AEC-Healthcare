package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");   
        PrintWriter out=resp.getWriter();
		try {
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			User u = new User(fullName, email, password);
			UserDao dao = new UserDao(DBConnect.getConn());
						
			
			boolean f=dao.register(u);
			
			if(f) {
				out.print("<marquee>User Registration successfull! Please LogIn below..</marquee>");     
	            req.getRequestDispatcher("user_login.jsp").include(req, resp);
		
			}
			else {
				out.print("<marquee>Oops! something went wrong..!</marquee>");     
	            req.getRequestDispatcher("signup.jsp").include(req, resp);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
