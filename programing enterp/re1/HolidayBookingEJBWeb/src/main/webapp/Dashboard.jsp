<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model1.EmployeeDTO" %>
 <%@ page import="model1.Department" %>
 <%@ page import="model1.Role" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

	<link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />
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
<link href="./css/indexstyles.css" rel="stylesheet" />

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="./js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</head>
<body class="bg-slate-800" id="page-top">


	<% String path =  request.getContextPath(); %>
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
						class="nav-link py-3 px-0 px-lg-3 rounded" href="<%out.print(path);%>">Dashboard</a></li>
				
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="<%out.print(path);%>/Logout">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	
	<section class="page-section portfolio" id="">
		<div class="container mt-5 d-flex justify-content flex-column">
	 <div class="mt-5  font-bold text-2xl" style="color: black;"><H1>Dashboard</H1></div>
	<div class="my-8 mt-5 p-12 grid grid-row-8 gap-4 text-white">
	<% 
	HttpSession httpSession = request.getSession(Boolean.TRUE);
	EmployeeDTO employee = (EmployeeDTO) httpSession.getAttribute("user");
    if (employee.getRole() == Role.Admin) {%>
	      <div><a class ="mt-5" href="<%out.print(path);%>/EMServlet">Employee List</a></div>
	      <div><a class ="mt-5" href="<%out.print(path);%>/EmployeeForm.jsp">Add Employee</a></div>
	      <div><a class ="mt-5" href="<%out.print(path);%>/LRServlet">Pending Leave Request</a></div>
	      <div><a class ="mt-5" href="<%out.print(path);%>/ESServlet">Employee Status</a></div>
	      <div><a class ="mt-5" href="<%out.print(path);%>/ARServlet">List of all Leave Request </a></div>
	      <%
	       } else {
	    	   %>
	   	  <div><a class ="mt-5" href="<%out.print(path);%>/HolidayRequestForm.jsp">Apply For Leave</a></div>
	      <div><a class ="mt-5" href="<%out.print(path);%>/UserLeaveList">My Leave Request </a></div>
	    	<% 	   
	       }
	 	   %>
	</div>
</body>
</html>