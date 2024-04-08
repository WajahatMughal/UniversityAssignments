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

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

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

</body>
</html>