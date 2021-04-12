<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
 <style>
      body{
        background-color: aliceblue;
      }
    </style>
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<div class="row justify-content-center">
				<h4 class="card-title" style="text-align: center">Billing/Shipping</h4>
			</div>
			<div class="row justify-content-center">
				<h6 class="card-subtitle mt-2 text-muted " style="text-align: center">Total: $<c:out value="${total}"/></h6>
			</div>
			<div class="row">
				<div class="container mt-3" >
					<form action="/cart/checkout" method="POST">
						<div class="form-group">
							<div class="row-lg">
								<div class="col">
									<label>First Name</label> <input class="form-control"/>
								</div>
								<div class="col">
									<label>Last Name</label> <input class="form-control"/>
								</div>
								<div class="col">
									<label>Street</label> <input class="form-control"/>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<label>City</label> <input class="form-control"/>
								</div>
								<div class="col">
									<label>Zip</label> <input class="form-control"/>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<label>Card Number</label> <input class="form-control" value="${cardnumber}"/>
								</div>
							</div>
							
							<div class="row">
								<div class="col">
									<label>cvv</label> <input class="form-control"/>
								</div>
								<div class="col">
									<label>Date</label> <input class="form-control"/>
								</div>
							</div>

						</div>
						<div class="row mt-3">
							<button type="submit" class="btn btn-primary">Submit
								Order</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</form>

				</div>
			</div>
			
		</div>
	</div>

	<div class="container mt-3">
		<div class="row mt-3"></div>
	</div>






	<%@ include file = "footer.jsp" %>

</body>
</html>