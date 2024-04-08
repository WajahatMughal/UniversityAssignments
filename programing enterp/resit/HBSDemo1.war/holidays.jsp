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
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
	<c:if test="${isAdmin}">
	<a href="admindash?action=main"
     class="nav-link">HOME</a>
	</c:if>
	<c:if test="${!isAdmin}">
	<a href="employeedash?action=main&id=<%=lId %>&type=<%=empType %>"
     class="nav-link">HOME</a>
	
	</c:if>
	
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

</body>
</html>