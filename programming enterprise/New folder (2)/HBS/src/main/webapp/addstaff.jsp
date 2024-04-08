<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Add Staff</title>
<!-- Favicon-->
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
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<!-- Navigation-->
	<%@ include file="nev.jsp" %>
			

<section class="page-section portfolio" id="">
		<div class="container mt-5 d-flex justify-content flex-column">
	<h1>Add Staff</h1>
	
	<h2><h3> My name is ${name}</h3>
	
<form class="d-flex justify-content flex-col" method="GET">
<div>
Full Name: <input type="text" name="fname" >
</div>
<div>
UserName: <input type="text" name="username" >
</div>
<div>
Password: <input type="text" name="password" >
</div>
<div>
Department: <select name="department">
<option value="Engineering">Engineering</option>
<option value="Plumbing">Plumbing</option>
<option value="Roofing">Roofing</option>
<option value="Carpentry">Carpentry</option>
<option value="Bricklying">Brictlaying</option>
<option value="Office">Office</option>
</select>
</div>
<div>
Role: <select name="role">
<option value="Head">Head</option>
<option value="Deputy Head">Deputy Head</option>
<option value="Manager">Manager</option>
<option value="Apprentice">Apprentice</option>
<option value="Junior Member">Junior Member</option>
<option value="Senior Member">Senior Member</option>
</select>
</div>
<div>
Joint Date: <input type="date" name="join_date" >
</div>
<div>
<input type="submit" value="submit" >
</div>


</form>
	</div>
	</section>
	
	
<% if(request.getParameter("username") != null){
	RequestDispatcher rd = request.getRequestDispatcher("HBSServlet?action=insertStaff");
	request.setAttribute("action", "insertStaff");
	request.setAttribute("fname", request.getParameter("fname"));
	request.setAttribute("username", request.getParameter("username"));
	request.setAttribute("password", request.getParameter("password"));
	request.setAttribute("department", request.getParameter("department"));
	request.setAttribute("role", request.getParameter("role"));
	request.setAttribute("join_date", request.getParameter("join_date"));
	rd.forward(request, response);
	
}

%>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>