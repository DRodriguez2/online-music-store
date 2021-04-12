<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Service Page</title>
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
<%@ include file = "navbar.jsp" %>
</head>
<body>

  
  
  <br><br>
  <p></p>
  <h2 class="text-center bg-info display-6"> Need some help? Look at the services we offer!</h2>
 	<div>
  <img src= "/images/musiclessons.jpg" class="rounded img-fluid">
  </div>
  <p class="text-center display-6"> We offer many services in our shop</p>
  <p class="text-center">You may search by typing what you are looking for</p>

  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <h3 class="text-center">Search</h3>
                <form action="SearchServices" class="text-center" method="POST">
                    <input type="text" placeholder="Search by name or brand" name="search">
                    <br></br> 
                    <input class="btn btn-primary" type="submit" value="Search">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    
                    </form>
            </li>
        </ul>
      </div>
    </div>
  </div>
 <br>
 <p class="text-center display-7">-OR-</p>

 <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <h3 class="text-center">Click and view all that we offer</h3>
                <form id="ViewServices" action="ViewServices" class="text-center" method="GET">
                    <button class="btn btn-primary">View all of our Wonderful Services</button>
                </form>
            </li>
        </ul>
      </div>
    </div>
  </div>
<p></p>


	<%@ include file = "footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

</body>
</html>