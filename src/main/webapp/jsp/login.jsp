<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log-in</title>

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
    
      <p></p>
      <div class="container" style = "background-color: rgb(172, 172, 169);">
        <div class="row">
          <div class="col">
            <ul class="list-group">
                <img src= "/images/musiclessons.jpg"lae"ross/as/asucj width="100" height="60" style="width:50%;">
            </ul>
          </div>
          <div class="col">
            <ul class="list-group">
                <img src= "/images/musicalbums.jpg" width="100" height="60" style="width:50%;">
            </ul>
          </div>
          <div class="col">
            <ul class="list-group">
                <img src= "/images/music band.jpg" width="100" height="60" style="width:50%;">
            </ul>
          </div>
          <div class="col">
            <ul class="list-group">
                <img src= "/images/music1.jpg" width="100" height="60" style="width:50%;">
            </ul>
          </div>
          <div class="col">
            <ul class="list-group">
                <img src= "/images/music3.jpg" width="100" height="60" style="width:50%;">
            </ul>
          </div>
          <div class="col">
            <ul class="list-group">
                <img src= "/images/music4.jpg" width="100" height="60" style="width:50%;">
            </ul>
          </div>
        </div>
      </div>

      <p></p>
  <div class="container">
    <div class="row">
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <h3>Login</h3>
                <p>Our online store is happy to serve you</p>
                <p>Insert a username and password</p>
                <p>-OR-</p>
                <p>Register now to begin online shopping!</p>
            </li>
        </ul>
      </div>
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
                <form action="/login" method="post">
   					User name: <input type="text" name="username" id="username" placeholder="username" required> <br><br>
    				Password: <input type="password" name="password" id="password" placeholder="password" required> <br><br>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" value="Log In"/>
				</form>
				<div class="pt-2">${result}</div>
            </li>

        </ul>
      </div>
    </div>
  </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>


</body>
</html>