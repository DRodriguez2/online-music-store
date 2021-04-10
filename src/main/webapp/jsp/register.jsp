<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<script type="text/javascript">
  function same() 
  {
      var x,y,z;
      x = document.getElementById("pass1").value;
      y = document.getElementById("pass2").value;
  
      if (x != y) 
      {
        alert("Password must match");
          return false;
      };
  }
  </script>

</head>
<body>
    
      <p></p>
      <div class="container" style = "background-color: rgb(172, 172, 169);">
        <div class="row">
          <div class="col">
            <ul class="list-group">
                <img src= "/images/musiclessons.jpg" width="100" height="60" style="width:50%;">
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
                <h3>Register</h3>
                <p>-Welcome new user!-</p>
                <p>Insert a username and password</p>
                <p></p>
                <p>Be sure to reconfirm your password</p>
            </li>
        </ul>
      </div>
      <div class="col">
        <ul class="list-group">
            <li class="list-group-item">
              <form action="#" method="#">
                Create a Username: <input type="text" name="newUN" id="newUN"> <br><br>
                Create a Password: <input type="text" name="pass1" id="pass1"> <br><br>
                Retype Your Password: <input type="text" name="pass2" id="pass2"> <br><br>
                <input type="submit" value="Submit" onClick="return same()"/>
            </form>
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