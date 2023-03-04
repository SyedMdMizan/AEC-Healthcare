package com.doctor.servlet;

import java.io.IOException;

import com.dao.AppointmentDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int did = Integer.parseInt(request.getParameter("did"));
			String comm = request.getParameter("comm");
			
			AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
			HttpSession session = request.getSession();
			if (dao.updateCommentStatus(id, did, comm)) {
				session.setAttribute("succMsg", "Comment Updated..");
				response.sendRedirect("doctor/patient.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something went wrong..");
				response.sendRedirect("doctor/patient.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
