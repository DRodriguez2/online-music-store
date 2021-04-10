<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md">
    <a class="navbar-brand" href="#"><img src="images/noodle.png" alt=""></a>
    <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main-navigation">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="music">Music</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/instruments">Instruments</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/services">Services</a>
        </li>
      </ul>
    </div>
    <div class="collapse navbar-collapse justify-content-end">
  		<ul class="navbar-nav">
  			<li class="nav-item active">
      			<a class="nav-link" href="/login">Login</a>
    		</li>
    		<li class="nav-item active">
      			<a class="nav-link" href="/cart">Cart</a>
    		</li>
  		</ul>
	</div>
  </nav>
</body>
</html>