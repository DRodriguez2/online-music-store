<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<nav class="navbar navbar-expand-md">
    
    
    <div class="collapse navbar-collapse" id="main-navigation">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/music">Music</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/instruments">Instruments</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/services">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/accessory">Accessories</a>
        </li>
      </ul>
    </div>
    <div class="collapse navbar-collapse justify-content-end">
  		<ul class="navbar-nav">
  		
  		
  		<%if(request.getSession().getAttribute("admin") != null) 
  		{%>
  			<li class="nav-item active">
			<a class="nav-link" href="/admin">Admin</a>
			</li>
  		<%}
  		%>
  		<%if(request.getSession().getAttribute("user") == null) 
  		{%>
  			<li class="nav-item active">
      			<a class="nav-link" href="/login">Login</a>
    		</li>
    		<li class="nav-item active">
      			<a class="nav-link" href="/register">Register</a>
    		</li>
  			<%}
  		%>
  		<%if(request.getSession().getAttribute("user") != null) 
  		{%>
    		<li class="nav-item active">
      			<a class="nav-link" href="/accountC">My Account</a>
    		</li>
  			
    		<li class="nav-item active">
      			<a class="nav-link" href="/login/logout">Logout</a>
    		</li>
    		
    	<%}
  		%>
    		<li class="nav-item active">
      			<a class="nav-link" href="/cart">Cart</a>
      		</li>
  		</ul>
	</div>
  </nav>
</body>
</html>