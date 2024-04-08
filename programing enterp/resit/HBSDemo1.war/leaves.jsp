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
   <h3 class="text-center">Leaves</h3>
   <hr>

   <br>
   <table class="table table-bordered text-center">
    <thead>
     <tr>
     <th>Requested Date</th>
     <th>Emp Name</th>
     <th>From Date</th>
     <th>To Date</th>
      <th>No of Days</th>
      <th>Reason</th>
      <th>Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="leave" items="${leaves}">

      <tr>
      <td><fmt:formatDate value="${leave.requestdate}" pattern="yyyy-MM-dd" />
       </td>
      <td><c:out value="${leave.employee.firstname} ${leave.employee.lastname}" /></td>
       <td><fmt:formatDate value="${leave.fromdate}" pattern="yyyy-MM-dd" />
       </td>
       <td><fmt:formatDate value="${leave.todate}" pattern="yyyy-MM-dd" />
       </td>
       <td><c:out value="${leave.noofdays}" /></td>
       <td><c:out value="${leave.reason}" /></td>
       <td><c:out value="${leave.status}" /></td>


       <td><a href="department?action=updateleave&status=Approved&id=<c:out value='${leave.id}' />">Accept</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="department?action=updateleave&status=Decline&id=<c:out value='${leave.id}' />">Decline</a></td>

      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>
 
 

 
 </div>

</body>
</html>