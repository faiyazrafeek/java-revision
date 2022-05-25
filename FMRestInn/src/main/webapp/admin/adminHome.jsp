<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("name") == null){
		response.sendRedirect("login.jsp");
	}
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FM Rest Inn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>  
  	<jsp:include page="adminNav.jsp" />   

    <div class="container">
    <h3 class="display-5 text-center my-4">Welcome to Admin Panel</h3>
    
   <div class="row row-cols-1 row-cols-md-3 g-4">
  <div class="col">
    	<div class="card">
		  <div class="card-body">
		    <a href="<%=request.getContextPath()%>/admin/rooms" class="card-title text-reset fs-4 text-decoration-none">Rooms</a>
		    <p class="card-text fs-3">8</p>
		    <a >Link</a>
		  </div>
		</div>
    </div>
    <div class="col">
    	<div class="card">
		  <div class="card-body">
		    <a href="<%=request.getContextPath()%>/admin/bookingList" class="card-title text-reset fs-4 text-decoration-none">Bookings</a>
		    <p class="card-text fs-3">8</p>
		    <a >Link</a>
		  </div>
		</div>
    </div>
    <div class="col">
    	<div class="card">
		  <div class="card-body">
		    <a href="#" class="card-title text-reset fs-4 text-decoration-none">Users</a>
		    <p class="card-text fs-3">8</p>
		    <a >Link</a>
		  </div>
		</div>
    </div>
    </div>
    </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>