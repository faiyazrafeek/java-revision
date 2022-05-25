<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container">
	    <a class="navbar-brand" href="../index.jsp">FM Rest Inn</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav me-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="adminHome.jsp">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/admin/new">Add Room</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/admin/bookingList">Bookings</a>
	        </li>
	       <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/admin/rooms">Available Rooms</a>
	        </li>
	      </ul>
	      <div>
		      <%
				if(session.getAttribute("name") == null){ 	
			  %>
			 	<a class="btn btn-primary" href="login.jsp">Admin Login</a>
	    	  <% }else{ %>
		        <a class="btn btn-danger" href="<%=request.getContextPath()%>/logout"">Logout</a>
	     	  <%} %>
      	  </div>
	    </div>
	  </div>
</nav>
