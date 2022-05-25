<%@page import="lk.fadesign.fmrestinn.model.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	if(session.getAttribute("name") == null){
		response.sendRedirect("login.jsp");
	}
	
	Room room = (Room) request.getAttribute("room");
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
	
	<div class="container mt-3">
		<div class="row">
			<div class="col">
			<% if(request.getAttribute("room") == null){ %>
				<h3 class="fs-3 mb-4">Add new Room</h3>
				<form method="post" action="addRoom">
			<%	}else{ %>
			
			<h3 class="fs-3 mb-4">Edit Room</h3>
			<form method="post" action="update">
			 <input type="hidden" id="id" name="id" value="<%= room.getId()  %>">
			<% } %>
				
		
				
				  <div class="row">
				  	<div class="col-md-6 mb-3">
				    <label for="title" class="form-label">Title</label>
				    <input type="text" class="form-control" id="title" name="title" value="<%= room != null ? room.getTitle(): ""  %>">
				  </div>
				  <div class="col-md-6">
				    <label for="description" class="form-label">Description</label>
				    <input type="text" class="form-control" id="description" name="description" value="<%= room != null ? room.getDescription() : ""  %>">
				  </div>
				  <div class="col-md-6 mb-3">
				    <label for="price" class="form-label">Price</label>
				    <input type="number" class="form-control" id="price" name="price" value="<%= room != null ?  room.getPrice() : ""  %>">
				  </div> 
				  <div class="col-md-6">
				    <label for="bed" class="form-label">Bed</label>
				    <input type="text" class="form-control" id="bed" name="bed" value="<%= room != null ?  room.getBed() : ""  %>">
				  </div>
				  <div class="col-md-6 mb-3">
				    <label for="type" class="form-label">Type</label>
				    <input type="text" class="form-control" id="type" name="type" value="<%= room != null ?  room.getType() : ""  %>">
				  </div>
				  <div class="col-md-6">
				    <label for="count" class="form-label">Count</label>
				    <input type="number" class="form-control" id="count" name="count" value="<%= room != null ?  room.getCount()  : "" %>">
				  </div>
				  <div class="col-md-6 mb-3">
				    <label for="image" class="form-label">Image URL</label>
				    <input type="text" class="form-control" id="image" name="image" value="<%= room != null ?  room.getImage() : ""  %>">
				  </div>
				  </div>
				  <% if(request.getAttribute("room") == null){ %>
				 <button type="submit" class="btn btn-primary">Add Room</button>
			<%	}else{ %>
			
			 <button type="submit" class="btn btn-success">Update Room</button>
			 <a href="rooms" class="btn btn-secondary">Cancel</button> </a>
			<% } %>
				 
				</form>	
			</div>
		</div>	
	</div>

    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>