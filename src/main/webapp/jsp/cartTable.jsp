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
<title>Cart</title>
</head>
<body>
	<div class="card justify-content-center">
		<div class="card-body justify-content-center">
			<div class="row justify-content-center">
				<h4 class="card-title" style="text-align: center">Your Cart</h4>
			</div>
			<div class="row">
				<div class="container mt-3" style="height: 300px; overflow: auto">
					<c:if test="${cart.size() == 0}">
						<h4 style="text-align: center">Empty Cart</h4>
						<div class="row mt-5">
							<h4 class="card-title" style="text-align: center; color:green">
								<c:out value="${result}" />
							</h4>
						</div>
					</c:if>
					<table class="table table-sm table-bordered">

						<c:forEach items="${cart}" var="product">
							<tr>
								<td style="border-left: none; border-right: none"><c:out
										value="${product.getName()}" /></td>
								<td style="border-left: none; border-right: none"><c:out
										value="$${product.getPrice()}" /></td>
								<td style="border-left: none; border-right: none"><c:out
										value="${product.getCategory()}" /></td>
								<td style="border-left: none; border-right: none">
									<form action="/cart/deleteItem" method="POST">
										<button type="submit" class="btn btn-danger">Remove</button>
										<input type="hidden" name="productId"
											value="${product.getId()}" /> <input type="hidden"
											name="${_csrf.parameterName}" value="${_csrf.token}" />
									</form>
								</td>
							</tr>
						</c:forEach>

					</table>

				</div>
			</div>
			<c:if test="${cart.size() != 0 }">
				<div class="row mt-3">
					<h4 class="card-title" style="text-align: right">
						Total: $
						<c:out value="${total}" />
					</h4>
				</div>
				<div class="row mt-3">
					<form action="/cart/checkout">
						<button type="submit" class="btn btn-success" style="float: right">Checkout</button>
						<input type="hidden" name="total" value="${total}" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</c:if>
		</div>
	</div>

	<div class="container mt-3">
		<div class="row mt-3"></div>
	</div>






	<!-- Footer -->
	<footer class="page-footer font-small indigo"> </footer>
	<!-- Footer -->

</body>
</html>