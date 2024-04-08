<html>
<head>
<title>Holiday Management System</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
<i class="fa fa-flag-checkered" aria-hidden="true"></i>
<h3 class="text-center">Straight Wall Ltd.</h3>
  </nav>
 </header>

 <div class="row">

  <div class="container">
   <h3 class="text-center">Holiday Management System</h3>
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
 <!--  <a href="login?action=adminLogin">Admin Login</a>  -->
        </div>
    
  </div>
 </div>

</body>
</html>