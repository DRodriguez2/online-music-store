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

<meta charset="ISO-8859-1">
<title>Admin Task</title>
</head>
<body>


	<div class="container mt-3">
		<h3>Accessories</h3>
		<div class="row mt-3">
			<div class="col">
				<form action="/admin/addAccessory">
					<button type="submit" class="btn btn-secondary">Add new accessory</button>
				</form>
			</div>
		</div>
	</div>

	<div class="container mt-3" style="height: 300px; overflow: auto">
		<table class="table table-sm table-striped table-bordered">
			<!-- here should go some titles... -->

			<tr>

			</tr>
			<c:forEach items="${request.getSession().getAttribute('cart')}" var="product">
				<tr>
					<td><c:out value="${product.getId()}" /></td>
					<td><c:out value="${product.getName()}" /></td>
					<td><c:out value="${product.getPrice()}" /></td>
					<td><c:out value="${product.getCategory()}" /></td>
					<td><c:out value="${accessory.getDescription()}" /></td>
					<td><form action="/cart/deleteItem">
							<button type="submit" class="btn btn-danger">Remove</button>
							<input type="hidden" name="productId" value="${product.getId()}" />
						</form></td>
				</tr>
			</c:forEach>

		</table>

	</div>




	<!-- Footer -->
	<footer class="page-footer font-small indigo"> </footer>
	<!-- Footer -->

</body>
</html>