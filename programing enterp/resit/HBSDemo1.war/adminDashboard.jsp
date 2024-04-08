<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Holiday Management System</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
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
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
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
   <h3 class="text-center">Holiday Management System</h3>
   <hr>
   <div class="container text-left">

   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
   
   <div class="container text-center">
   
   <div class="container text-center">

    <a href="department?action=list" style="width: 130px;"
     class="btn btn-success">Department</a>
     &nbsp;&nbsp;&nbsp;&nbsp; 
     <a href="employee?action=list" style="width: 130px;"
     class="btn btn-success">Employee</a>
     &nbsp;&nbsp;&nbsp;&nbsp; 
     <a href="holiday?action=leavesForApprove&lId=<%=lId %>" style="width: 130px;"
     class="btn btn-success">Leaves</a>
     &nbsp;&nbsp;&nbsp;&nbsp; 
     <a href="role?action=list" style="width: 130px;"
     class="btn btn-success">Role</a>
   </div>
   <br>
   
   
   
        </div>
                
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto; align-items: center;">
        </div>
    
  </div>
 </div>

</body>
</html>