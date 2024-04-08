<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Department" %>
 <%@ page import="model.Role" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
<link rel="stylesheet"
	href="./fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="./css/style.css">
<!-- JS -->
	<script src="./vendor/jquery/jquery.min.js"></script>
	<script src="./js/main.js"></script>
</head>
<body>



	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Add Employee</h2>
						<%-- <%
				 Boolean loginFailed = (Boolean) request.getAttribute("Loginfailed"); 
				 String  message = (String) request.getAttribute("Message"); 
				 if ((loginFailed != null) &&(loginFailed == true )) { %>
				<div id="alert">
					<div
						class="mt-2.5 bg-red-100 border-t-4 border-red-500 rounded text-red-900 px-4 py-3 shadow-md"
						role="alert"
					>
						<div class="flex">
							<div class="py-1">
								<svg class="fill-current h-6 w-6 text-red-500 mr-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
									<path
										d="M2.93 17.07A10 10 0 1 1 17.07 2.93 10 10 0 0 1 2.93 17.07zm12.73-1.41A8 8 0 1 0 4.34 4.34a8 8 0 0 0 11.32 11.32zM9 11V9h2v6H9v-4zm0-6h2v2H9V5z"
									/>
								</svg>
							</div>
							<div>
								<p class="font-bold"> Login Failed </p>
								<p class="text-sm" id="errorMessage"> <% out.print(message); %></p>
							</div>
						</div>
					</div>
				</div>
				<% } %> --%>
					
						<form method="POST" action="InsertEmployee" id="employeeForm" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
							Join date:	<label for="date"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="joindate" id="date"
									placeholder="Join date" />
							</div>
							
							<div class="form-group">
								Birth date:<label for="dateofbirth"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="dateofbirth" id="dateofbirth"
									placeholder="Birth date" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="address" id="address"
									placeholder="Address" />
							</div>
							<div class="form-group">
								<label for="postcode"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="postcode" id="postcode"
									placeholder="postcode" />
							</div>
							<div class="form-group">
								<label for="phonenumber"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="phonenumber" id="phonenumber"
									placeholder="Contact no" />
							</div>
							
								
							<div class="form-group">
							Department:
							<select
								id="department"
								name="department"
								form="employeeForm"
								
								required
								class="appearance-none rounded-none relative block w-full px-3 py-3 text-white placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm"
								
							>
								<%  for (Department value  : Department.values()) {%>
									<option class="font-black" value="<% out.print(value.toString()); %>"/> <% out.print(value.toString()); %></option>
								<% }%>
		
							</select>
							</div>
							<div class="form-group">
							Role: 
							<select
								id="role"
								name="role"
								form="employeeForm"
								
								required
								class="appearance-none rounded-none relative block w-full px-3 py-3 text-white placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm"
								
							>
								<%  for (Role value  : Role.values()) {%>
									<option class="font-black" value="<% out.print(value.toString()); %>"/> <% out.print(value.toString()); %></option>
								<% }%>
		
							</select>
							</div>
							<div class="form-group form-button">
								<input type="submit"  id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="index.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>




</body>
</html>