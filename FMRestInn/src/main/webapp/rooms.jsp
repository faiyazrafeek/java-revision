<%@page import="java.util.ArrayList"%>
<%@page import="lk.fadesign.fmrestinn.model.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% ArrayList rooms = (ArrayList)request.getAttribute("roomList"); %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FM Rest Inn | Rooms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>  

			<jsp:include page="navBar.jsp" />  
   
		
	<div class="container">
	<h4 class="text-center my-4 fs-2">Choose our best rooms for your preference</h4>
	<div class="row">	

	<% for (int count = 0; count < rooms.size(); count++){ %>	
		<div class="col">
			<% Room room = (Room) rooms.get(count); %>
			<div class="card  position-relative" style="width: 18rem;">
				<span class="position-absolute top-0 end-0 badge bg-warning">
				   <%= room.getCount() %> Rooms Available
				    <span class="visually-hidden">unread messages</span>
				  </span>
				  <img src="<%= room.getImage() %>" class="card-img-top" alt="<%= room.getTitle() %> image">
				  <div class="card-body">
				    <h5 class="card-title"><%= room.getTitle() %></h5>
				    <p class="card-text"><%= room.getDescription() %></p>
				   <input type="hidden" id="room_id" value=<%= room.getId() %>>
				    <p class="card-text">
				    	<span class="badge rounded-pill text-bg-success">Rs. <%= room.getPrice() %></span>
				    	<span class="badge rounded-pill text-bg-danger"><%= room.getBed() %> Bed</span>
				    	<span class="badge rounded-pill text-bg-warning"><%= room.getType() %></span>
				    </p>				    
				   
						<a href="bookRoom.jsp?room_id=<%= room.getId() %>&cost=<%= room.getPrice() %>" id="btn_book" class="btn btn-primary">Book Now</a>
				   
				  </div>
				</div>		
		</div>
		
		
	
	<% } %>	

	</div>
	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>