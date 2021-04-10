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
		<h3>Instruments</h3>
		<div class="row mt-3">
			<div class="col">
				<form action="/admin/addInstrument">
					<button type="submit" class="btn btn-secondary">Add new instrument</button>
				</form>
			</div>
		</div>
	</div>

	<div class="container mt-3" style="height: 500px; overflow: auto">
		<table class="table table-sm table-striped table-bordered">
			<!-- here should go some titles... -->

			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Brand</th>
				<th>Actions</th>
			</tr>



			<c:forEach items="${searchResults}" var="instrument">
				<tr>
					<td><c:out value="${instrument.getId()}" /></td>
					<td><c:out value="${instrument.getName()}" /></td>
					<td><c:out value="${instrument.getType()}" /></td>
					<td><c:out value="${instrument.getPrice()}" /></td>
					<td><c:out value="${instrument.getBrand()}" /></td>
					<td><form action="/admin/task">
							<button type="submit" class="btn btn-primary">More
								Info/Actions</button>
							<input type="hidden" name="productId"
								value="${instrument.getId()}" /> <input type="hidden"
								name="category" value="${instrument.getCategory()}" />
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