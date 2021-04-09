<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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

<meta charset="ISO-8859-1">
<title>Register User</title>

<%@ include file = "navbar.jsp" %>
</head>
<body>


<h2>Please Enter Your Information To Register</h2>


	<form action="/register" method="post"> <!-- Passing values to register new user -->
    	Create a Username: <input type="text" name="uname" id="uname" placeholder="Username"> <br><br>
    	Create a Password: <input type="text" name="pass1" id="pass10" placeholder="Password"> <br><br>
    	Retype Your Password: <input type="text" name="pass2" id="pass2" placeholder="Must match inital password"> <br>
    	
    </form>	
    
<h2>Enter Credit Card Information</h2>    

	<form action="/register" method="post"> 
	
	Enter Credit Card Number: <input type="number" name="credit" id="credit" placeholder="#XXXX-XXXX-XXXX-XXXX"> <br> <br>
	
	</form>
	<input type="submit" value="Submit" onClick="return register"> 
</body>
</html>