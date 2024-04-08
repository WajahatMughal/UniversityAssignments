<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"
	href="./fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="./css/style.css">
<!-- JS -->
	<script src="./vendor/jquery/jquery.min.js"></script>
	<script src="./js/main.js"></script>
		<meta charset="UTF-8" />
		<title>Login</title>
	</head>
	<body>
				
			<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
			<div>
				
					
					<%			 	 
			 	Boolean InvalidLoginErr=(Boolean)request.getAttribute("InvalidLoginErr");
			 	if(InvalidLoginErr == null)
			 		InvalidLoginErr=false;
		      	if (request.getParameter("email") != null &&
		      		request.getParameter("password") != null && !InvalidLoginErr
		      		)
		      	{
		      		//alert(1);
		      		RequestDispatcher rd = request.getRequestDispatcher("Authe");
		      		request.setAttribute("actiontype", "login");
		      		request.setAttribute("email", request.getParameter("email"));
		      		request.setAttribute("password", request.getParameter("password"));
		      		rd.forward(request, response);
		      	}
		      %>
			
				<%
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
				<% } %>
				
			
			</div>
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="get" action="Authe" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="email"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="email" name="email" id="email"
									placeholder="Your email" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit"  id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</section>

	</div>
			
				
			
		
	</body>
	<script>
		function showError(message) {
			console.log(message);
			const alert = document.getElementById('alert');
			alert.style.display = 'block';
			const messageElement = document.getElementById('errorMessage');
			messageElement.innerHTML = message;
			setTimeout(function () {
				alert.style.display = 'none';
			}, 2000);
		}

		function loginUser() {
			const email = document.getElementById('email').value;
			const password = document.getElementById('password').value;
			if (email == '') {
				showError('Please enter vaild a email');
			}
			if (password == '') {
				showError('Please enter your password');
			}
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function () {
				if (!this.response.status) {
					showError('wrong username/password enterd');
				}
			};
			/*xhttp.open('GET', 'AuthServlet');
			xhttp.setRequestHeader(
				'Content-type',
				'application/x-www-form-urlencoded'
			);
			xhttp.send('email=' + email + '&password=' + password);*/
		}
	</script>
</html>
