<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
	
	<a href="employeedash?action=main&id=${holidaypojo.employeeId}&type=${empType}"
     class="nav-link">HOME</a>
   </div>
   <h3 class="text-center">Straight Wall Ltd.</h3>


   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li>Hi <%=name %> !!!</li>
    <li><a href="login?action=logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">

  <div class="container">
   <h3 class="text-center">Leave Details</h3>
   <hr>
   <div class="container text-left">
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
<h5 style="color: red;">${violation}</h5>

            <form action="holiday?action=insertEmpLeave" method="post">

                <div class="form-group">
                <input type="hidden" id="id" name="id" value="${holidaypojo.id}">
                <input type="hidden" id="employeeId" name="employeeId" value="${holidaypojo.employeeId}">
                
                    <label for="name">From Date:</label> <input type="text" class="form-control" id="fromDate" name="fromDate" autocomplete="off" required>
                    <label for="name">To Date:</label> <input type="text" class="form-control" id="toDate" name="toDate" autocomplete="off" required>
                </div>
                
                <div class="form-group">
                    
                    <input type="hidden" id="assignTo" name="assignTo" value="${Employee.hod.id}">
				        
				        <br/>
                    <label for="name">Reason:</label> <input type="text" class="form-control" id="reason" name="reason" value="<c:out value="${holidaypojo.reason}"/>" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    
  </div>
 </div>

</body>
</html>