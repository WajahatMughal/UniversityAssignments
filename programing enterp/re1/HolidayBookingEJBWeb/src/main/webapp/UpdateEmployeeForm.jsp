<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model1.Department" %>
 <%@ page import="model1.Role" %>
 <%@ page import ="model1.EmployeeDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee Form</title>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               

	<link rel="stylesheet"
	href="../fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="../css/style.css">
<!-- JS -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../js/main.js"></script>
		
</head>
<body>



	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<%  EmployeeDTO employee = (EmployeeDTO) request.getAttribute("employee");
				        if (employee != null) {
				        	 %>
		
					<div class="signup-form">
					
						<h2 class="form-title">Add Employee</h2>
						
					
						<form method="post" action="<%out.print(employee.getId()); %>" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" value=<% if (employee.getName().length() > 0) out.print(employee.getName()); else out.print(""); %> id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" value=<% if (employee.getEmail().length() > 0) out.print(employee.getEmail()); else out.print(""); %> id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="pass" value=<% if (employee.getAddress().length() > 0) out.print(employee.getAddress()); else out.print(""); %> placeholder="Password" />
							</div>
							<div class="form-group">
							Join date:	<label for="date"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="joindate" id="date" value=<% if (employee.getJoinDate() > 0) out.print(employee.getJoinDate()); else out.print(""); %>
									placeholder="Join date" />
							</div>
							
							<div class="form-group">
								Birth date:<label for="dateofbirth"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="dateofbirth" id="dateofbirth" value=<% if (employee.getDateOFBirth() > 0) out.print(employee.getDateOFBirth()); else out.print(""); %>
									placeholder="Birth date" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="address" id="address" value=<% if (employee.getAddress().length() > 0) out.print(employee.getAddress()); else out.print(""); %>
									placeholder="Address" />
							</div>
							<div class="form-group">
								<label for="postcode"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="postcode" id="postcode" value=<% if (employee.getPostCode().length() > 0) out.print(employee.getPostCode()); else out.print(""); %>
									placeholder="postcode" />
							</div>
							<div class="form-group">
								<label for="phonenumber"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="phonenumber" id="phonenumber" value=<% if (employee.getPhoneNumber().length() > 0) out.print(employee.getPhoneNumber()); else out.print(""); %>
									placeholder="Contact no" />
							</div>
							
								
							<div class="form-group">
							Department:
							<select
								id="department"
								name="department"
								form="employeeForm"
								value=<% out.print(employee.getDepartment());%>
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
								value=<% out.print(employee.getRole());%>
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
							<img src="../images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="index.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				
					<% }  %>
				</div>
			</div>
		</section>


	</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
		$('#role option[value="${employee.getRole()}"]').attr('selected','selected');
		$('#department option[value="${employee.getDepartment()}"]').attr('selected','selected');		

	</script>
		
</body>
</html>