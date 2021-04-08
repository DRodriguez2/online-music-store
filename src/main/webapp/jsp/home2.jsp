<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<title>Homepage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.2.slim.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-md"> <a class="navbar-brand"
		href="#"><img src="images/noodle.png" alt=""></a>
	<button class="navbar-toggler navbar-dark" type="button"
		data-toggle="collapse" data-target="#main-navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="main-navigation">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="PH.html">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="PH.html">Music</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="PH.html">Instruments</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="PH.html">Services</a>
			</li>
		</ul>
	</div>
	</nav>

	<h1>Homepage</h1>
	<%@ include file = "testMusicTable.jsp" %>

	<!-- Footer -->
	<footer class="page-footer font-small indigo"> </footer>
	<!-- Footer -->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.2.slim.min.js"></script>

</body>
</html>