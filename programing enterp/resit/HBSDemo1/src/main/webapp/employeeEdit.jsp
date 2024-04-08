<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

</head>
<%
String lId = null;
String name = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("lId")) {
		lId = cookie.getValue();
	}
	if(cookie.getName().equals("name")) {
		name = cookie.getValue();
	}
}
}
%>


</head>
<body>
 	<nav
		class="navbar navbar-expand-lg  text-uppercase fixed-top" style="background-image: linear-gradient(140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%)"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="admindash?action=main">Holiday Booking System</a>
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
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Dashboard">Hi <%=name %> !</a></li>
					
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="login?action=logout">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</nav>

<section class="page-section portfolio" id="">
<div class="container mt-5 d-flex justify-content ">
  <div class="container">
   <h3 class="text-center">Employee Details</h3>
   <hr>
   <div class="container text-left">
  <div class="text-right">
                <a href="employee?action=list" class="btn btn-success">List All Employees</a>
                </div>
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <form action="employee?action=insert"  method="post">

				<div class="form-group">
               		<input type="hidden" id="id" name="id" value="<c:out value="${employeepojo.id}"/>">
               		<input type="hidden" id="totalLeaves" name="totalLeaves" value="<c:out value="${employeepojo.totalholidays}"/>">
               		<input type="hidden" id="holidayBal" name="holidayBal" value="<c:out value="${employeepojo.holidatybal}"/>">
                    <label for="name">First Name:</label> <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstname" value="<c:out value="${employeepojo.firstName}"/>" required>
                    <label for="name">Last Name:</label> <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastname" value="<c:out value="${employeepojo.lastName}"/>" required>
                </div>
                
                <div class="form-group">
                	<label for="name">Email:</label> <input type="text" class="form-control" id="email" placeholder="Email ID" name="email" value="<c:out value="${employeepojo.email}"/>" required>
                    <label for="name">Employee Type:</label> <select name="empType" ="<c:out value="${employeepojo.empType}"/>">
				        <c:forEach items="${employeepojo.empTypes}" var="empTypeName">
				            <option value="${empTypeName}" ${empTypeName == employeepojo.empType ? 'selected="selected"' : ''}>${empTypeName}</option>
				        </c:forEach>
    				</select>
                </div>

                <div class="form-group">
                	<label for="name">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="<c:out value="${employeepojo.password}"/>" required>
                    <label for="name">Department:</label> <select name="departmentid" value="<c:out value="${employeepojo.departmentId}"/>">
				        <c:forEach items="${employeepojo.departments}" var="dept">
				            <option value="${dept.id}" ${dept.id == employeepojo.departmentId ? 'selected="selected"' : ''}>${dept.name}</option>
				        </c:forEach>
				        </select>
                </div>
                
                <div class="form-group">
                	<label for="name">role:</label> <select name="roleId" >
				        <c:forEach items="${employeepojo.roles}" var="role">
				            <option value="${role.id}" ${role.id == employeepojo.roleId ? 'selected="selected"' : ''}>${role.name}</option>
				        </c:forEach>
				        </select>
				        
                    <label for="name">Reporting To:</label> <select name="reportingToId" >
				        <c:forEach items="${employeepojo.employees}" var="emp">
				            <option value="${emp.id}" ${emp.id == employeepojo.reportingToId ? 'selected="selected"' : ''}>${emp.firstname} ${emp.lastname}</option>
				        </c:forEach>
				        </select>
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    
  </div>
 </div>
</section>
</body>
</html>