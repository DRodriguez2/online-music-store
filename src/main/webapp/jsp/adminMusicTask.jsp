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

	<h1>ADMIN TASK</h1>

	<div class="row">
		<div class="col">
			<div class="container p-3 my-3 bg-dark text-white row-full">
				<h3>Edit or Delete Product</h3>
				<form:form action="/admin/task" method="POST" modelAttribute="music">
					<div class="form-group">

						<form:label path="id">Product Id</form:label>
						<form:errors path="id" style="color:red; font-style:italic;" />
						<form:input path="id" class="form-control" value="${music.getId()}" readonly="readonly" />

						<form:label path="name">Name</form:label>
						<form:errors path="name" style="color: red; font-style:italic;" />
						<form:input path="name" class="form-control" required="required" value="${music.getName()}" />

						<form:label path="category">Category</form:label>
						<form:errors path="category" style="color: red; font-style:italic;" />
						<form:input path="category" class="form-control" readonly="readonly"
							value="${music.getCategory()}" />

						<form:label path="price">Price</form:label>
						<form:errors path="price" style="color: red; font-style:italic;" />
						<form:input path="price" class="form-control"
							required="required" value="${music.getPrice()}" />

						<form:label path="type">Type</form:label>
						<form:errors path="type" style="color: red; font-style:italic;" />
						<form:input path="type" class="form-control" readonly="readonly"
							value="${music.getType()}" />

						<form:label path="artist">Artist</form:label>
						<form:errors path="artist" style="color: red; font-style:italic;" />
						<form:input path="artist" class="form-control"
							required="required" value="${music.getArtist()}" />

						<form:label path="genre">Genre</form:label>
						<form:errors path="genre" style="color: red; font-style:italic;" />
						<form:input path="genre" class="form-control"
							required="required" value="${music.getGenre()}" />

					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
				<form action="/admin/delete" method="POST">
						<button type="submit" class="btn btn-primary">Delete</button>
						<input type="hidden" name="productId" value="${music.getId()}" /><input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>