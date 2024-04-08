<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Holiday Management System</title>

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
			<a class="navbar-brand" href="employeedash?action=main&id=${holidaypojo.employeeId}&type=${empType}">Holiday Booking System</a>
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
   <hr>
   <div class="container text-left">

   <div class="text-right">
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
</div>
   
   <div class="container text-center">
   
   <div class="container text-center">
 
     <a href="holiday?action=editEmpLeave&empid=${empid}" style="width: 130px;"
     class="btn btn-success">Create Leave</a>
     <c:if test="${showButton}">
     <a href="holiday?action=leavesForApprove&lId=${empid}" style="width: 130px;"
     class="btn btn-success">Check Leave</a>
     </c:if>
     
     

   </div>
   <br>
   <table class="table table-bordered text-center">
    <thead>
     <tr>
     <th>Requested Date</th>
     <th>Leave Date</th>
      <th>Reason</th>
      <th>Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="leave" items="${holidays}">

      <tr>
      <td><fmt:formatDate value="${leave.requestdate}" pattern="yyyy-MM-dd" />
       </td>
       <td><fmt:formatDate value="${leave.holidaydate}" pattern="yyyy-MM-dd" />
       </td>
       <td><c:out value="${leave.reason}" /></td>
       <td><c:out value="${leave.status}" /></td>

       <td><a href="holiday?action=delete&id=<c:out value='${leave.id}' />">Delete</a></td>

      </tr>
     </c:forEach>
    </tbody>

   </table>
   
   
   
        </div>
                
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto; align-items: center;">
        </div>
    
  </div>
 </div>
</section>
</body>
</html>