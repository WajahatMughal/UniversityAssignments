<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model1.EmployeeDTO" %>
<%@ page import="model1.HolidayDTO" %>
<%@ page import="java.util.List"%>
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
<title>Holiday Booking</title>
</head>
	<body class="bg-slate-600">
	
	
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
	
	
	
		<H1 class="heading accent-white p-6 pb-3 font-bold"
			>Select User</H1>
			
    <form method="post" action="AllRequest" class=" py-6">
    <label class="text-white"> Name </label>
  		<select
			id="Employee"
			name="Employee"
			required
			class="appearance-none rounded-none relative block w-full px-3 py-3 placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm">
			<%  
			List<EmployeeDTO> employeelist = (List<EmployeeDTO>) request.getAttribute("employeeList");
			if (employeelist != null) {
			for (EmployeeDTO employee  : employeelist) {%>
				<option class="font-black" value="<% out.print(employee.getId()); %>"/> <% out.print(employee.getName().toString()); %></option>
			<% }
			}
			%>
		</select>
    <Button class="" type="submit"> Show </Button>
</form>
<%
 EmployeeDTO selectedDate = (EmployeeDTO) request.getAttribute("employee");
 if (selectedDate != null) { %>
<H1 class="heading accent-white p-6 pb-3 font-bold"
			>Request Made by <% out.print(selectedDate.getName());%></H1>
<%}  %>
    <div class="px-6 py-6">
		<div class="py-6 min-w-full shadow-sm shadow-slate-700 bg-slate-700 rounded-md border-gray-500 rounded-t ">
			<table class="min-w-full bg-slate-500 rounded-md backdrop-blur-sm table-auto">
				<thead class="py-3 px-4 backdrop-blur-sm bg-slate-700 rounded-t">
						<tr class="backdrop-blur-sm">
						<th class="px-3 py-2">From </th>
						<th class="px-3 py-2">To</th>
						<th class="px-3 py-2">Reason</th>
						<th class="px-3 py-2">Employee ID</th>
						<th class="px-3 py-2">Role</th>
						<th class="px-3 py-2">Department</th>
						<th class="px-3 py-2">Status</th>
					</tr>
				</thead>
				<tbody>
				<%  
				List<HolidayDTO> list = (List<HolidayDTO>) request.getAttribute("requestlist");
				        if (list != null) {
				        	for( HolidayDTO leave : list) { 				        	
				  %>
				    <tr class=" accent-white text-center  backdrop-blur-sm" >
				     <td class="px-3 py-2"><% out.print(leave.getFromDate().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getToDate().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getReason()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getId()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getRole().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getDepartment().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getStatus().toString()); %></td>
                     </tr>
                    <% }
				     }
				    %>
				</tbody>
			</table>
		</div>
    </div>
	
	
	
	</div>
	</section>
	
	</body>
</html>