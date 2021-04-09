
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Admin page</title>
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
  
<h2>Add Accessory</h2>

<form id="AddAccessory" action="AddAccessory" method="post">
    <label>Name: </label>
    <input type="text" name="name">
    <br/>
    <label>Brand: </label>
    <input type="text" name="brand">
    <br/>
    <label>Description: </label>
    <input type="text" name="description">
    <br/>
    <label>price: </label>
    <input type="number" name="price">
    <br/>
    <button>Submit</button>
</form>


  
</form>
  
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