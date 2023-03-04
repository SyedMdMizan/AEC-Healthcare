<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.entity.*" %>
    <%@page import="com.dao.DoctorDao" %>
    <%@page import="com.db.DBConnect" %>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Dashboard</title>
<%@include file="../component/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
</head>
<body>
<%@include file="navbar.jsp" %>
<c:if test= "${empty docobj }">
	<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
<%
Doctor d = (Doctor)session.getAttribute("docobj");
DoctorDao dao = new DoctorDao(DBConnect.getConn());%>
<p class="text-center fs-3 text-success">Doctor Dashboard</p>
<div class="continer p-5">
	<div class="row">
		<div class="col-md-4 offset-md-2">
 			<div class="card paint-card">
 				<div class="card-body text-center text-success">
 					<i class="fas fa-user-md fa-3x"></i><br>
 					<p class="fs-4 text-center">
 						Doctor <br> <%=dao.countDoctor() %>
 					</p>
 				</div>		
 			</div>
 		</div>
 		<div class="col-md-4">
 			<div class="card paint-card">
 				<div class="card-body text-center text-success">
 					<i class="fa-solid fa-calendar-check fa-3x"></i><br>
 					<p class="fs-4 text-center">
 						Total Appointment <br> <%=dao.countAppointmentByDoctorId(d.getId()) %>
 					</p>
 				</div>		
 			</div>
 		</div>
	</div>
</div>

</body>
</html>