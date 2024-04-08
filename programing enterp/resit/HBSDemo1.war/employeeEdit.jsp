<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

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
   <div>
	
	<a href="admindash?action=main"
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

</body>
</html>