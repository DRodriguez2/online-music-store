<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<title>Homepage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet" />


<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>

	<%@ include file="navbar.jsp"%>
	<div class="row mt-5"></div>
	<div class="row mt-5"></div>
			

	
	
	<div class="row" style="height: auto">
		<div class="col-3"></div>
		<div class="col-6">
			<h1 >Cart</h1>	
			<div class="card justify-content-center">
				<div class="card-body justify-content-center">
				<div class="row justify-content-center">
					<h4 class="card-title" style="text-align:center">Your Order</h4>
				</div>
				<div class="row">
					<%@ include file="cartTable.jsp"%>
					This is some text within a card body.
				</div>
				
				
				
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>



</body>


</html>