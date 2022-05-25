<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>FM Rest Inn | Login</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

  </head>
  <body > 
  <jsp:include page="adminNav.jsp" />    
	<div class="container">
		<h3 class="fs-4 text-center my-5">Admin Login</h3>
		<div class="row" style="height: 100vh;">
		    <div class="col-md-4">
		   
		    </div>
		    <div class="col-md-4 mt-6 pt-6" >
		      <form method="POST" action="login">
			  <div class="mb-3">
			    <label for="username" class="form-label">USername</label>
			    <input type="text" class="form-control" id="username" name="username">
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Password</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <button type="submit" class="btn btn-primary">Login</button>
			  <a href="../index.jsp" class="btn btn-secondary">Go to Home</a>
			</form>
		    </div>
		    <div class="col-md-4">
		    
		    </div>
		 </div>
	</div>


    
  </body>
</html>
