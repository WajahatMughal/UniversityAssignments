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
   <h3 class="text-center">List of Roles</h3>
   <hr>
   <div class="container text-left">

<div class="text-right">
    <a href="role?action=new"
     class="btn btn-success">Add Role</a>
     </div>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Name</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="role" items="${listRoles}">

      <tr>
       <td><c:out value="${role.name}" /></td>

       <td><a href="role?action=edit&id=<c:out value='${role.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="role?action=delete&id=<c:out value='${role.id}' />">Delete</a></td>

      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>

</body>
</html>