<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.EmployeeStatus"%>
<%@ page import="model1.EmployeeDTO" %>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
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

<meta charset="UTF-8">
<title>Employee Status</title>
</head>
 <body class="bg-slate-600">
 
		<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Holiday Booking System</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary  rounded"
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
	
 
<H1 class="heading  p-6 pb-3 font-bold"
			>Select Date</H1>
 <form method="post" action="EmployeeStatus" class="">
    <label class=""> Date </label>
    <input 	id="date"
			name="date"
			type="date"
			autocomplete="date"
			required
			class=""
			/>
    <Button class="" type="submit"> Show </Button>
</form>
<%
 Date selectedDate = (Date) request.getAttribute("date");
 if (selectedDate != null) { %>
<H1 class="heading accent-white p-6 pb-3 font-bold"
			>Employees Working Date <% out.print(selectedDate.toString());%></H1>
<%}  %>
    <div class="px-6 py-6">
		<div class="py-6 min-w-full shadow-sm shadow-slate-700 bg-slate-700 rounded-md border-gray-500 rounded-t ">
	<table class="min-w-full bg-slate-500 rounded-md backdrop-blur-sm table-auto">
				<thead class="py-3 px-4 backdrop-blur-sm bg-slate-700 rounded-t">
					<tr class="backdrop-blur-sm">
						<th class="px-3 py-2">Employee Name</th>
						<th class="px-3 py-2">Role</th>
						<th class="px-3 py-2">Department</th>
						<th class="px-3 py-2">Email</th>
						<th class="px-3 py-2">Working</th>
            <th class="px-3 py-2"></th>
					</tr>
				</thead>
				<tbody>
				<%  List<EmployeeStatus> list = (List<EmployeeStatus>) request.getAttribute("employeelist");
				        if (list != null) {
				        	for( EmployeeStatus employeeStatus : list) { 
				        		EmployeeDTO employee = employeeStatus.getEmployee();
				      %>
				    <tr class=" accent-white text-center  backdrop-blur-sm" >
				     <td class="px-3 py-2"><% out.print(employee.getName()); %></td>
                     <td class="px-3 py-2"><% out.print(employee.getRole().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(employee.getDepartment().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(employee.getEmail()); %></td>
                     <td class="px-3 py-2"><%out.print(employeeStatus.getWorking());%></td>
				    </tr>
				   	<% }   
				         }%>
				</tbody>
			</table>
		</div>
    </div>


</div>
</section>
</body>
</html>