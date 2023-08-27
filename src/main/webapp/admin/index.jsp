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
<title>Admin Dashboard</title>
<%@include file="../component/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
</head>
<body>
<%@include file="navbar.jsp" %>

<c:if test= "${empty adminobj }">
	<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>
<%DoctorDao dao = new DoctorDao(DBConnect.getConn());%>
<div class="container p-5">
	<p class="text-center fs-3">Admin Dashboard</p>
 	<div class="row">
 		<div class="col-md-4">
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
 					<i class="fas fa-user-circle fa-3x"></i><br>
 					<p class="fs-4 text-center">
 						User <br> <%=dao.countUser() %>
 					</p>
 				</div>		
 			</div>
 		</div>
 		<div class="col-md-4">
 			<div class="card paint-card">
 				<div class="card-body text-center text-success">
 					<i class="fa-solid fa-calendar-check fa-3x"></i><br>
 					<p class="fs-4 text-center">
 						Total Appointment <br> <%=dao.countAppointment() %>
 					</p>
 				</div>		
 			</div>
 		</div>
 		<div class="col-md-4 mt-2">
 			<div class="card paint-card" data-bs-toggle="modal" data-bs-target="#exampleModal">
 				<div class="card-body text-center text-success">
 					<i class="fa-solid fa-stethoscope fa-3x"></i><br>
 					<p class="fs-4 text-center">
 						Specialist <br> <%=dao.countSpecialist() %>
 					</p>
 				</div>		
 			</div>
 		</div>
 	</div>
 </div>
</body>
</html>