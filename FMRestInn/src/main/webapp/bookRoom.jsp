<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FM Rest Inn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>  
  	<jsp:include page="navBar.jsp" />   
	<div class="container mt-3">
		<div class="row">
			<div class="col">
				<h3 class="fs-3 mb-4">Enter your details to book a room</h3>
		
				<form method="post" action="bookRoom">
				  <div class="row">
				   <div class="col-md-6 mb-3">
				    <label for="name" class="form-label">Name</label>
				    <input type="text" class="form-control" id="name" name="name">
				  </div>
				  
			  	  <div class="col-md-3 mb-3">
				    <label for="checkindate" class="form-label">Check-In Date</label>
				    <input type="date" class="form-control" id="checkindate" name="checkindate">
				  </div>
				  <div class="col-md-3">
				     <label for="checkoutdate" class="form-label">Check-Out Date</label>
				    <input type="date" class="form-control" id="checkoutdate" name="checkoutdate">
				  </div>
				 
				    <input type="hidden" class="form-control" id="room_id" name="room_id" value=<%= request.getParameter("room_id") %>>
			
				 <div class="col-md-6">
				    <label for="address" class="form-label">Address</label>
				    <input type="text" class="form-control" id="address" name="address">
				  </div>
				   <div class="col-md-3 mb-3">
				    <label for="bed" class="form-label">Bed Type</label>
				    <select class="form-select" name="bed" id="bed" aria-label="Default select example">
					  <option value="1">Single</option>
					  <option value="2">Double</option>
					  <option value="3">Triple</option>
  					  <option value="4">Quad</option>
					</select>
				  </div>
				  <div class="col-md-3 mb-3">
				    <label for="meal" class="form-label">Meal Plan</label>
				    <select class="form-select" id="meal" name="meal" aria-label="Default select example">
					  <option value="room">Room Service</option>
					  <option value="self">Self Meal</option>
					  <option value="breakfast">Breakfast Only</option>
					</select>
				  </div>
				  <div class="col-md-3">
				    <label for="email" class="form-label">Email</label>
				    <input type="email" class="form-control" id="email" name="email">
				  </div>
				  <div class="col-md-3 mb-3">
				    <label for="phone" class="form-label">Phone</label>
				    <input type="text" class="form-control" id="phone" name="phone">
				  </div>
				  
				 
				  <div class="col-md-2 mb-3">
				    <label for="costroom" class="form-label">Cost Per Room</label>
				    <input type="number" readonly="readonly" value="<%= request.getParameter("cost") %>" class="form-control" id="costroom" name="costroom">
				  </div>
				  <div class="col-md-2">
				    <label for="rooms" class="form-label">No. of Rooms</label>
				    <input type="number" class="form-control" id="rooms" name="rooms">
				  </div>
				  <div class="col-md-2">
				    <label for="totalcost" class="form-label">Total Cost</label>
				    <input type="number" class="form-control" readonly="readonly" id="totalcost" name="totalcost">
				  </div>
				  </div>
				  
				  <button type="submit" class="btn btn-primary ms-auto">Book Now</button>
				</form>	
			</div>
		</div>	
	</div>

    <script type="text/javascript">
    var rooms = document.getElementById("rooms").value;
    var amount = <%= request.getParameter("cost") %>
    
    document.getElementById("rooms").onkeyup = function(){
    	document.getElementById("totalcost").value = document.getElementById("rooms").value * amount
			
    }
    </script>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>