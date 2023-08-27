<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.entity.*" %>
    <%@page import="com.dao.*" %>
    <%@page import="com.db.DBConnect" %>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Details</title>
<%@include file="../component/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
</head>
<body>
<%@include file="navbar.jsp" %>
	<div class="col-md-12">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-3 text-center">Patient Details</p>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Full Name</th>
								<th scope="col">Gender</th>
								<th scope="col">Age</th>
								<th scope="col">Appointment Date</th>
								<th scope="col">Email</th>
								<th scope="col">Mob No</th>
								<th scope="col">Symptoms</th>
								<th scope="col">Doctor Name</th>
								<th scope="col">Address</th>
								<th scope="col">Status</th>
								
							</tr>
						</thead>
						<tbody>
						<% 
						AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
						DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
							List<Appointment> list= dao.getAllAppointment();
							for(Appointment ap : list) {
								Doctor d = dao2.getDoctorById(ap.getDoctorId());
						%>
							<tr>
								<th><%=ap.getFullName() %></th>
								<td><%=ap.getGender() %></td>
								<td><%=ap.getAge() %></td>
								<td><%=ap.getAppoinDate() %></td>
								<td><%=ap.getEmail() %></td>
								<td><%=ap.getPhNo() %></td>
								<td><%=ap.getDiseases() %></td>
								<td>Dr. <%=d.getFullName() %></td>
								<td><%=ap.getAddress() %></td>
								<td><%=ap.getStatus() %></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>