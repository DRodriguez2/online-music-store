<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Accessory Page</title>
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

  <%@ include file = "navbar.jsp" %>
  
  <br><br>
  <p></p>
  <h2 class="text-center bg-info"> Need a new way to listen to your favorite hits?</h2>
  <p class="text-center bg-info"> We have you covered!</p>
    <p></p>
  <img src= "/images/music3.jpg" width="500" height="300" style="width:50%;">
  <p class="text-center"> We have many Accessories in our shop</p>
  <p class="text-center">You may search by typing what you are looking for</p>

  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <h3 class="text-center">Search</h3>
                <form action="SearchAccessory" class="text-center" method="POST">
                    <input type="text" placeholder="Search by name or brand" name="search">
                    <br><br>
                    <input type="submit" value="Submit">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                    </form>
            </li>
        </ul>
      </div>
    </div>
  </div>
 
 <p class="text-center">-OR-</p>

 <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <h3 class="text-center">Click and view all that we have in stock</h3>
                <form id="ViewAccessory" action="ViewAccessory" class="text-center" method="GET">
                    <button >View all of our Accessories</button>
                </form>
            </li>
        </ul>
      </div>
    </div>
  </div>
<p></p>


	<!-- Footer -->
	<footer class="page-footer font-small indigo">
    
        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">Music Store 1234 Broadway St., San Antonio TX. � 2018 Copyright
        </div>
        <!-- Copyright -->
    
      </footer>
	<!-- Footer -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

</body>
</html>