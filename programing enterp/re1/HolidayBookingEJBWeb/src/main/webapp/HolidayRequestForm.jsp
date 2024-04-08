<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Leave Request</title>
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
<link href="css/indexstyles.css" rel="stylesheet" />	

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</head>
 <body>
 
 
 	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Holiday Booking System</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary  rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Dashboard">Dashboard</a></li>
					
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
			

<section class="page-section portfolio" id="">
<div class="container mt-5 d-flex justify-content flex-column">
	
	<H1> Employee Leave Request</H1>
  <form method="POST" action="HolidayRequest">
  		<label>From Date</label>
		<input
			id="fromdate"
			name="fromdate"
			type="date"
			autocomplete="date"
			required
			class="appearance-none rounded-none relative block w-full px-3 py-3  placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm"
			placeholder="From Dates"
		/>
    	<label>TO Date</label>
		<input
			id="todate"
			name="todate"
			type="date"
			autocomplete="date"
			required
			class="appearance-none rounded-none relative block w-full px-3 py-3  placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm"
			placeholder="To Dates"
		/>
		<label>Reason</label>
		<input
			id="reason"
			name="reason"
			type="text"
			required
			class="appearance-none rounded-none relative block w-full px-3 py-3  placeholder-gray-500 rounded focus:outline-none focus:ring-amber-500 focus:border-amber-500 focus:z-10 sm:text-sm"
			placeholder="Reason"
		/>
		<button type="submit"> Submit </button>
	  </form>
	
	</div>
	</section>
	
 
 
 
 
</body>
</html>