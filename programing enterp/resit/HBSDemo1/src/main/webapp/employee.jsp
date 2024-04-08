<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
   <h3 class="text-center">List of Employees</h3>
   <hr>
   <div class="container text-left">

<div class="text-right">
      <a href="employee?action=new"
     class="btn btn-success">Add Employee</a>
   </div>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Name</th>
      <th>Department</th>
      <th>Role</th>
      <th>Employee Type</th>
      <th>Email</th>
      <th>Head of Dept</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="emp" items="${empList}">

      <tr>
       <td><c:out value="${emp.firstname} ${emp.lastname}" /></td>
       <td><c:out value="${emp.department.name}" /></td>
       <td><c:out value="${emp.role.name}" /></td>
       <td><c:out value="${emp.employeetype}" /></td>
       <td><c:out value="${emp.email}" /></td>
       <td><c:out value="${emp.hod.firstname} ${emp.hod.lastname}" /></td>

       <td><a href="employee?action=edit&id=<c:out value='${emp.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="employee?action=delete&id=<c:out value='${emp.id}' />">Delete</a></td>

      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>
</section>
</body>
</html>