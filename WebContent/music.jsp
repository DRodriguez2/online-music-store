<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Music Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>


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
          <a class="nav-link" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="music.jsp">Music</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="PH.html">Instruments</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="PH.html">Services</a>
        </li>
      </ul>
    </div>
    <div class="collapse navbar-collapse justify-content-end">
  		<ul class="navbar-nav">
    		<li class="nav-item active">
      			<a class="nav-link" href="cart.jsp">Cart</a>
    		</li>
  		</ul>
	</div>
  </nav>
  
  <form action="#">
  	<input type="text" placeholder="Search.." name="search">
  	<br><br>
  	<input type="radio" id="title" name="title" value="title" style="margin-left: 5px">
  		<label for="title">By Title</label>
  	<input type="radio" id="artist" name="artist" value="artist" style="margin-left: 5px">
  		<label for="artist">By Artist  </label>
  	<input type="radio" id="style" name="style" value="style" style="margin-left: 5px">
  		<label for="style">By Style  </label>
  	<input type="radio" id="format" name="format" value="format" style="margin-left: 5px">
  		<label for="format">By Format  </label>
  	<input type="radio" id="price" name="price" value="price" style="margin-left: 5px">
  		<label for="price">By Price  </label>
  	<br>
  	<input type="submit" value="Submit">
   </form> 
  <br><br>
  <h1>This is where we will display songs/albums</h1>
  

	<!-- Footer -->
	<footer class="page-footer font-small indigo">
	
	</footer>
	<!-- Footer -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

</body>
</html>