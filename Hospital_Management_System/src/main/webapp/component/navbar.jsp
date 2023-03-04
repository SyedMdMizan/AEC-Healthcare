	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %> 
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-stethoscope"></i> AEC Healthcare</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
			
			<c:if test="${empty userobj }">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="admin_login.jsp"><i
						class="fa-solid fa-right-to-bracket"></i> Admin</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="doctor_login.jsp">Doctor</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="user_appointment.jsp">Appointment</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="user_login.jsp">User</a></li>
			</c:if>
				

				<c:if test="${not empty userobj }">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="user_appointment.jsp">Book Appointment</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="view_appointment.jsp">View Appointment</a></li>
				
				    <li class="dropdown">
				    <button class="btn btn-success dropdown-toggle" type="button"
				    id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fa-solid fa-user"></i> ${userobj.fullName }
				    </button>
				    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            			<li>
            				<a class="dropdown-item" href="UserLogout">Logout</a>
            			</li>
            		</ul>
         </li>
				
				</c:if>
				 



			</ul>
		</div>
	</div>
</nav>