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
<title>Doctor</title>
<%@include file="../component/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-3 text-center">Add Doctor</p>
					<c:if test="${not empty errorMsg }">
						<p class="fs-4 text-center text-danger">${errorMsg }</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<c:if test="${not empty succMsg }">
						<p class="fs-4 text-center text-success">${succMsg }</p>
						<c:remove var="succMsg" scope="session" />
					</c:if> 
					<form action="../AddDoctor" method="post">
						<div class="mb-3">
							<label class="form-label">Full Name</label>
							<input type="text" required name="fullname" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">DOB</label>
							<input type="date" required name="dob" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Qualification</label>
							<input type="text" required name="qualification" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Email</label>
							<input type="text" required name="email" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Contact</label>
							<input type="text" required name="mobno" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label>
							<input type="password" required name="password" class="form-control">
						</div>
						<button type="submit" class="btn btn-success form-control">Submit</button>
					</form>
				</div>
			</div>
		</div>
		
		<div class="col-md-8">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-3 text-center">Doctor Details</p>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Full Name</th>
								<th scope="col">DOB</th>
								<th scope="col">Qualification</th>
								<th scope="col">Email</th>
								<th scope="col">Contact</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
						<% 
							DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
							List<Doctor> list2 = dao2.getAllDoctor();
							for(Doctor d:list2)
							{
						%>
							<tr>
							<td>Dr. <%=d.getFullName() %></td>
							<td><%=d.getDob() %></td>
							<td><%=d.getQualification() %></td>
							<td><%=d.getEmail() %></td>
							<td><%=d.getMobNo() %></td>
							<td>
							<a href="edit_doctor.jsp?id=<%=d.getId() %>" class="btn btn-sm btn-primary">Edit</a>
							<a href="../DeleteDoctor?id=<%=d.getId() %>" class="btn btn-sm btn-danger">Delete</a>
							</td>
							
						</tr>
						<%}
						%>
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>