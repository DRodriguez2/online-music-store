<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        
<html lang="en">
<head>
  
  <title>Task Result</title>
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
  <img src= "/images/music3.jpg" width="500" height="300" style="width:50%;">
  <h3 class="text-center">Task result successful</h3>
<p></p>
<h4>You may perform a new task or return home</h4>
<form id="AdminTask" action="AdminTask" method="post">
  <label>Entity: </label>
  <select name="entity">
  <option value="Music">Music</option>
  <option value="Instrument">Instrument</option>
  <option value="Services">Services</option>
  <option value="Accessory">Accessory</option>
  <option value="Album">Album</option>
</select>
<label>Action: </label>
  <select name="action">
  <option value="add">Add</option>
  <option value="update">Update</option>
  <option value="delete">Delete</option>
</select>
  <button>Submit</button>
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