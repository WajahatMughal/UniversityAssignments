<html>
<head>
<title>Holiday Management System</title>


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

</head>
<body>
 <header>
<nav
		class="navbar navbar-expand-lg  text-uppercase fixed-top" style="background-image: linear-gradient(140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%)"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="">Holiday Booking System</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
			
			</div>
		</div>
	</nav>

<section class="page-section portfolio" id="">
<div class="container mt-5 d-flex justify-content ">

  <div class="container">
   <h3 class="text-center">Login</h3>
   <hr>
   <div class="container text-center">
   <h5 style="color: red;">${error}</h5>
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <form action="login?action=employeeLogin" method="post">

                <div class="form-group">
                
                    <label for="name">Email</label> <input type="text" class="form-control" id="email"  name="name" required>
                </div>

				<div class="form-group">
                
                    <label for="pass">Password</label> <input type="password" class="form-control" id="pass"  name="pass" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
                
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto; align-items: center;">
   <h3 class="text-center">Admin Login</h3>
        </div>
     <form action="login?action=adminLogin" method="post">

                <div class="form-group">
                
                    <label for="name">Email</label> <input type="text" class="form-control" id="email"  name="name" required>
                </div>

				<div class="form-group">
                
                    <label for="pass">Password</label> <input type="password" class="form-control" id="pass"  name="pass" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
  </div>
 </div>
</section>
</body>
</html>