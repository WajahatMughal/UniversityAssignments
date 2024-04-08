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
   <h3 class="text-center">Holiday Management System</h3>
   <hr>
   <div class="container text-left">
   <div class="text-right">
   
                <a href="department?action=list" class="btn btn-success">List All Roles</a>
                </div>
   
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <form action="role?action=insert" method="post">

                <div class="form-group">
                <input type="hidden" id="id" name="id">
                    <label for="name">Role Name:</label> <input type="text" class="form-control" id="name" placeholder="Role Name" name="name" required>
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    
  </div>
 </div>

</body>
</html>