<%@page import="lk.fadesign.fmrestinn.model.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lk.fadesign.fmrestinn.model.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("name") == null){
		response.sendRedirect("login.jsp");
	}
%>
    
    <% ArrayList bookings = (ArrayList)request.getAttribute("bookingList"); %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FM Rest Inn | Rooms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>  
  	<jsp:include page="adminNav.jsp" />   
		
	<div class="container">
	<h4 class="text-center my-4 fs-2">Booked Room Details</h4>
	<table class="table table-striped">
		<tr>
	      <th>#</th>
	      <th>User</th>	     
	      <th>Phone</th>
	      <th>Room #</th>
	      <th>Check-In</th>
	      <th>Check-Out</th>
	      <th>Bed</th>
	      <th>Meal</th>
	      <th>Rooms</th>
	      <th>Total Cost</th>
	      <th>Actions</th>
	    </tr>
		

	<% for (int count = 0; count < bookings.size(); count++){ %>	
		<tr>
			<% Booking book = (Booking) bookings.get(count); %>
			<% request.getSession().setAttribute("booking", book); %>
			<td> <%= book.getId() %> </td>
			<td> <%= book.getUser().getName() %> </td>
			<td> <%= book.getUser().getPhone() %> </td>
			<td> <%= book.getRoom().getId() %> </td>
			<td> <%= book.getCheckout() %> </td>
			<td> <%= book.getCheckin() %> </td>
			<td> <%= book.getBed() %> </td>
			<td> <%= book.getMeal() %> </td>
			<td> <%= book.getRooms() %> </td>
			<td> <%= book.getTotalcost() %> </td>
			
			<td> 
				<form action="approveRoom" method="POST">
				<input type="hidden" value=<%= book.getId() %> name="book_id" id="book_id">
			
			
	<% if(Integer.parseInt(book.getStatus()) == 0){  %>  	
	<button type='submit' class='btn btn-primary btn-sm'>Approve</button> 
	
	
	
	 <% }else{  %>  	<button type='submit' disabled="disabled" class='btn btn-warning btn-sm'>Approved</button> 
		<% }  %> 
				</form>
			</td>
		</tr>
		
		
	
	<% } %>	
</table>
	</div>
	
	<script type="text/javascript">
	
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>