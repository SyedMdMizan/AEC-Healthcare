package com.doctor.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		Doctor doc=dao.login(email, password);
		
		if(doc != null) {
			session.setAttribute("docobj", doc);
			response.sendRedirect("doctor/index.jsp");
		}
		else {
			session.setAttribute("errorMsg", "invalid email or password");
			response.sendRedirect("doctor_login.jsp");
		}
		
	}

}
