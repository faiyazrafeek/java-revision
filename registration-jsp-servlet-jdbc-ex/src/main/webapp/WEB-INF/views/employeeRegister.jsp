<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
<body>
	<div class="container mt-5">
		<h1 class="my-4">Employee Registration</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
  			<div class="mb-3">
		    	<label class="form-label">First Name</label>
	    		<input type="text" class="form-control" name="firstName">
	  		</div>
	  		
	  		<div class="mb-3">
		    	<label class="form-label">Last Name</label>
	    		<input type="text" class="form-control" name="lastName">
	  		</div>
	  		
	  		<div class="mb-3">
		    	<label class="form-label">Username</label>
	    		<input type="text" class="form-control" name="username">
	  		</div>
	  		
	  		<div class="mb-3">
		    	<label class="form-label">Password</label>
	    		<input type="text" class="form-control" name="password">
	  		</div>
	  		
	  		<div class="mb-3">
		    	<label class="form-label">Address</label>
	    		<input type="text" class="form-control" name="address">
	  		</div>
	  		
	  		<div class="mb-3">
		    	<label class="form-label">Contact</label>
	    		<input type="text" class="form-control" name="contact">
	  		</div>

 			 <button type="submit" class="btn btn-primary">Save Employee</button>
		</form>
	</div>	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>