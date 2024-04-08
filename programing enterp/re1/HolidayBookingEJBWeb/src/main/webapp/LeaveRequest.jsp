<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.LeaveRequest" %>
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

<title>Leave Request</title>
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
			>Pending Leave Request</H1>
    <div class="px-6 py-6">
		<div class="py-6 min-w-full shadow-sm shadow-slate-700  rounded-md  rounded-t ">
			<table class="min-w-full  rounded-md backdrop-blur-sm table-auto">
				<thead class="py-3 px-4 backdrop-blur-sm  rounded-t">
					<tr class="backdrop-blur-sm">
						<th class="px-3 py-2">From </th>
						<th class="px-3 py-2">To</th>
						<th class="px-3 py-2">Reason</th>
						<th class="px-3 py-2">Employee ID</th>
						<th class="px-3 py-2">Role</th>
						<th class="px-3 py-2">Department</th>
						<th class="px-3 py-2">Constraints</th>
						<th class="px-3 py-2"></th>
            <th class="px-3 py-2"></th>
					</tr>
				</thead>
				<tbody>
				<%  
				List<LeaveRequest> list = (List<LeaveRequest>) request.getAttribute("requestlist");
				        if (list != null) {
				        	for( LeaveRequest leaveRequest : list) { 
				        		HolidayDTO leave = leaveRequest.getLeave();
				        	
				  %>
				    <tr class="  text-center  backdrop-blur-sm" >
				     <td class="px-3 py-2"><% out.print(leave.getFromDate().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getToDate().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getReason()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getId()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getRole().toString()); %></td>
                     <td class="px-3 py-2"><% out.print(leave.getEmployee().getDepartment().toString()); %></td>
                     <td class="px-3 py-2">
                     <ul class=" ">
                     <%
                     List<String> constraints = leaveRequest.getConstraints();
                     if (constraints.size() > 0) {
                       for(String item : constraints) {
                     %>
                     <li>
                     <%
                      out.print(item);
                     %>
                     </li>
                          <%
				        	}
				         }
                     %>
                     </ul>
                     </td>
                     <td class="px-3 py-2">
                      <form method="post" action="LeaveRequest/1_<%out.print(leave.getId());%>">
                      <button class=" h-12 w-12 p-4 items-center" style="color:black" >Accept</i></button></form>
                      </td>
                      <td class="px-3 py-2">
                      <form method="post" action="LeaveRequest/0_<%out.print(leave.getId());%>">
                      <button class=" h-12 w-12 p-4 items-center" style="color:black" >Reject</i></button></form>
                      </td>
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