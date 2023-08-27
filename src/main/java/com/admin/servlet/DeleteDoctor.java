package com.admin.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("id"));
		
		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		HttpSession session = request.getSession();
		
		if(dao.deleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor Deleted Successfully");
			response.sendRedirect("admin/doctor.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong..");
			response.sendRedirect("admin/doctor.jsp");
		}
		
	}

	

}
