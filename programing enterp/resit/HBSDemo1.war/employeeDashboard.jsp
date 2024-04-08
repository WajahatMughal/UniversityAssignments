<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

</body>
</html>