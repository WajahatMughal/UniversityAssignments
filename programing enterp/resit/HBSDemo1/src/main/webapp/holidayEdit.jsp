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
<body>
<script>
$( function() {

	$( "#fromDate" ).datepicker();
    $( "#toDate" ).datepicker();
});
</script>
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
   <h3 class="text-center">Leave Details</h3>
   <hr>
   <div class="container text-left">
   <div class="text-right">
                <a href="holiday?action=list" class="btn btn-success">List All Leaves</a>
                </div>
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
<h5 style="color: red;">${violation}</h5>
            <form action="holiday?action=insertEmpLeave" method="post">

                <div class="form-group">
                <input type="hidden" id="id" name="id" value="${holidaypojo.id}">
                <input type="hidden" id="employeeId" name="employeeId" value="${holidaypojo.employeeId}">
                
                    <label for="name">From Date:</label> <input type="text" class="form-control" id="fromDate" name="fromDate" required>
                    <label for="name">To Date:</label> <input type="text" class="form-control" id="toDate" name="toDate" required>
                </div>
                
                <div class="form-group">
                    <label for="name">Assign To:</label> <select name="assignTo" >
				        <c:forEach items="${holidaypojo.employees}" var="emp">
				            <option value="${emp.id}" ${emp.id == holidaypojo.assignTo ? 'selected="selected"' : ''}>${emp.firstname} ${emp.lastname}</option>
				        </c:forEach>
				        </select>
				        <br/>
                    <label for="name">Reason:</label> <input type="text" class="form-control" id="reason" name="reason" value="<c:out value="${holidaypojo.reason}"/>" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    
  </div>
 </div>
</section>
</body>
</html>