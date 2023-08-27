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
<title>Appointment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<div class="container p-3">
	<div class="row">
		<div class="col-md-8">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 fw-bold text-center text-success">Appointment List</p>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Full Name</th>
								<th scope="col">Gender</th>
								<th scope="col">Age</th>
								<th scope="col">Appoint Date</th>
								<th scope="col">Symptoms</th>
								<th scope="col">Doctor Name</th>
								<th scope="col">Status</th>
							</tr>
						</thead>
						<tbody>
							<%
							User user = (User) session.getAttribute("userobj");
							AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
							DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
							List<Appointment> list=dao.getAllAppointmentByLoginUser(user.getId());
							for(Appointment ap : list) {
								Doctor d = dao2.getDoctorById(ap.getDoctorId());
							%>
							<tr>
								<th><%=ap.getFullName() %></th>
								<td><%=ap.getGender() %></td>
								<td><%=ap.getAge() %></td>
								<td><%=ap.getAppoinDate() %></td>
								<td><%=ap.getDiseases() %></td>
								<td>Dr. <%=d.getFullName() %></td>
								<td>
								<%
								if("Pending".equals(ap.getStatus())) { %>
									<a href="#" class="btn btn-sm btn-warning disabled">Pending</a> <%
									}
								else
								{ %>
								<%=ap.getStatus() %>
								<%
								}
							
								%>
								</td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
				
			</div>
		</div>
		<div class="col-md-4 p-3">
			<img alt="" src="img/abc.png" width="400px">
		</div>
	</div>
</div>


</body>
</html>