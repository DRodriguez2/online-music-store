<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log-in</title>

<%@ include file = "navbar.jsp" %>
</head>
<body>
    <form action="/login" method="get">
    User name: <input type="text" name="username" id="username" placeholder="username" required> <br><br>
    Password: <input type="text" name="password" id="password" placeholder="password" required> <br><br>
    <input type="hidden" id = "" name ""> <!-- have to pass hidden value -->
    <input type="submit" value="Log in" onclick=""/>
	</form>
	
	<button onclick="window.location.href='register'">Register</button>
</body>
</html>