package com.user.servlet;

import java.io.IOException;

import com.dao.AppointmentDAO;
import com.db.DBConnect;
import com.entity.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userid"));
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String appoint_date = request.getParameter("appoint_date");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String diseases = request.getParameter("diseases");
		int doctor_id = Integer.parseInt(request.getParameter("doct"));
		String address = request.getParameter("address");
		
		Appointment ap=new Appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctor_id, address, "Pending");
		AppointmentDAO dao=new AppointmentDAO(DBConnect.getConn());
		HttpSession session = request.getSession();
		
		if(dao.addAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment booked successfully..");
			response.sendRedirect("user_appointment.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("user_appointment.jsp");
		}
	}

}
