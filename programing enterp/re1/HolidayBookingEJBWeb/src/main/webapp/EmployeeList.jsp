<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model1.EmployeeDTO" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
	
<!-- Font Icon -->
<!-- Favicon-->

		<title>Employee List</title>
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/indexstyles.css" rel="stylesheet" />	

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

	</head>
	<body id="page-top" >
	
		<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Holiday Booking System</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Dashboard">Dashboard</a></li>
					
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
			

<section class="page-section portfolio" id="">
<div class="container mt-5 d-flex justify-content flex-column">
	
	
	
	<div class="container mt-5 d-flex justify-content flex-column">
	<h1>All Staff</h1>
	<table class="  table table-striped">
	<thead>
		<tr>
		  <th scope="col">Name</th>
		  <th scope="col">Email</th>
		  <th scope="col">Department</th>
		  <th scope="col">Role</th>
		  <th scope="col">Update</th>
		  <th scope="col">Delete</th>
		  
		  
		  
		</tr>
	  </thead>
	  <tbody>
		<%  List<EmployeeDTO> list = (List<EmployeeDTO>) request.getAttribute("employeelist");
				        if (list != null) {
				        	for( EmployeeDTO employee : list) { %>
		<tr>
		  
		  <td><% out.print(employee.getName()); %></td>
		  <td><% out.print(employee.getEmail()); %></td>
		  <td><% out.print(employee.getDepartment()); %></td>
		  <td><% out.print(employee.getRole()); %></td>
		  <td><a href="UpdateEmp/<%out.print(employee.getId());%>" class="btn btn-info" >update</a></td>
		  <td><form method="post" action="DeleteEmployee/<%out.print(employee.getId());%>"><button class="btn btn-danger" value="delete"><i class="gg-user-remove"></i>X</button></form>
                  </td>
		</tr>

	 	<% }   
				         }%>
		
</table>

</div> 
	
	
	</div></section>
	
	
	
	
	</body>
</html>
