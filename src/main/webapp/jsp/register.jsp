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
<title>Register</title>
</head>
<body>
	<form action="#" method="#">
    	Create a Username: <input type="text" name="newUN" id="newUN"> <br><br>
    	Create a Password: <input type="text" name="pass1" id="pass1"> <br><br>
    	Retype Your Password: <input type="text" name="pass2" id="pass2"> <br><br>
    	<input type="submit" value="Submit" onClick="return same()"/>
	</form>
</body>
</html>