<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
String empType = null;
String isAdmin = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("lId")) {
		lId = cookie.getValue();
	}
	if(cookie.getName().equals("name")) {
		name = cookie.getValue();
	}
	if(cookie.getName().equals("empType")) {
		empType = cookie.getValue();
	}
	if(cookie.getName().equals("isadmin")) {
		isAdmin = cookie.getValue();
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
			<a class="navbar-brand" href="">Holiday Booking System</a>
			<c:if test="${isAdmin}">
	<a href="admindash?action=main"
     class="nav-link">HOME</a>
	</c:if>
	<c:if test="${!isAdmin}">
	<a href="employeedash?action=main&id=<%=lId %>&type=<%=empType %>"
     class="nav-link">HOME</a>
	
	</c:if>
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
   <h3 class="text-center">Leaves</h3>
   <hr>
   <div class="container text-right">

    <!-- <a href="holiday?action=new"
     class="btn btn-success">Add Leaves</a> -->
   </div>
   <br>
   <table class="table table-bordered text-center">
    <thead>
     <tr>
     <th>Requested Date</th>
     <th>Emp Name</th>
     <th>Leave Date</th>
      <th>Reason</th>
      <th>Status</th>
      <th>Violations</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="leave" items="${holidays}">

      <tr>
      <td>${leave.requestedDate}
       </td>
      <td><c:out value="${leave.employeeName}" /></td>
       <td>${leave.holidayDate}
       </td>
       <td><c:out value="${leave.reason}" /></td>
       <td><c:out value="${leave.status}" /></td>
       <td><c:forEach var="reason" items="${leave.violations}">
       <c:out value="${reason}" /><br/>
       </c:forEach>
       </td>

       <td>
       <c:if test="${!leave.isViolating}">
       
       <a href="holiday?action=updateleave&status=Approved&lId=<c:out value='${leave.id}' />">Accept</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="holiday?action=updateleave&status=Decline&lId=<c:out value='${leave.id}' />">Decline</a></td>
        </c:if>

      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>
 
 

 
 </div>
</section>
</body>
</html>