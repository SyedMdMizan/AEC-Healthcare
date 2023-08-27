package com.admin.servlet;

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

@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");
			String password = request.getParameter("password");
			int id=Integer.parseInt(request.getParameter("id"));
			
			Doctor d = new Doctor(id, fullName, dob, qualification, email, mobno, password);
			
			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			HttpSession session = request.getSession();
			
			if(dao.updateDoctor(d)) {
				session.setAttribute("succMsg", "Doctor Updated Successfully");
				response.sendRedirect("admin/doctor.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something went wrong..");
				response.sendRedirect("admin/doctor.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
