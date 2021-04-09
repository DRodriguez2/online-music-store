<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Homepage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    <style>
      img{
        display:block;
        margin-left: auto;
        margin-right: auto;
      }
      body{
        background-color: aliceblue;
      }
    </style>

</head>
<body>
  
  <h1>Music Store</h1>
	<p>The Music Store built for music lovers like us</p>
  <div class="container">
    <div class="row">
      <div class="col" style = "background-color: rgb(233, 233, 168);">
  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"></li>
      <li data-bs-target="#myCarousel" data-bs-slide-to="1"></li>
      <li data-bs-target="#myCarousel" data-bs-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="carousel-item active">
        <img src="/images/music1.jpg" alt="Los Angeles" style="height:300px; width:100%; margin: auto;">
        <div class="carousel-caption">
          <h3>Instruments</h3>
          <p>Preowned and New</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="/images/music3.jpg" alt="Chicago" style="height: 300px; width:100%; margin:auto;">
        <div class="carousel-caption">
          <h3>Accessories</h3>
          <p>New Bose headphones in stock</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="/images/music4.jpg" alt="New York" style="height:300px; width:100%; margin:auto;">
        <div class="carousel-caption">
          <h3>Music and Albums</h3>
          <p>70's, 80's, Modern, and Classics</p>
        </div>
      </div>

    </div>

    
    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>
  </div>
</div>
<div class="col" style = "background-color: rgb(233, 233, 168);">

 <h1>Welcome to Music Store!</h1>
 <p>We have a selection of items far and wide here</p>
</div>
</div>
</div>

  <p></p>

  <img src= "/images/music band.jpg" width="500" height="300" style="width:50%;">
  <p class="text-center bg-info"> Carrying Instruments for your Band or Hobby</p>
  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">Guitars</li>
            <li class="list-group-item">Pianos</li>
            <li class="list-group-item">Drums</li>
        </ul>
      </div>
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">Woodwinds</li>
            <li class="list-group-item">Pianos</li>
            <li class="list-group-item">Brass</li>
        </ul>
      </div>
    </div>
  </div>

  <p></p>

  <img src= "/images/musiclessons.jpg" width="500" height="300" style="width:50%;">
  <p class="text-center bg-info"> We provide services and classes</p>
  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">Instrument tuning</li>
            <li class="list-group-item">Singing Lessons</li>
        </ul>
      </div>
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">Instrument Lessons</li>
            <li class="list-group-item">Performance</li>
        </ul>
      </div>
    </div>
  </div>

  <p></p>
  <img src= "images/musicalbums.jpg" width="500" height="300" style="width:50%;">
  <p class="text-center bg-info"> We have modern and classics available</p>
  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">Rock</li>
            <li class="list-group-item">70's</li>
            <li class="list-group-item">80's</li>
            <li class="list-group-item">90's</li>
        </ul>
      </div>
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">KPop</li>
            <li class="list-group-item">Pop</li>
            <li class="list-group-item">Rap</li>
            <li class="list-group-item">Alternative Jazz</li>
        </ul>
      </div>
    </div>
  </div>

	<!-- Footer -->
	<footer class="page-footer font-small indigo">
    
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">Music Store 1234 Broadway St., San Antonio TX. © 2018 Copyright
    </div>
    <!-- Copyright -->

  </footer>
	<!-- Footer -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

</body>
</html>