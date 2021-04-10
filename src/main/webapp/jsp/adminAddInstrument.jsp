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
	<div class="col-8">
		<div class="container p-3 my-3 row-full">
			<div class="container">
				<h3>Add Instrument</h3>
				<form:form action="/admin/addInstrument" method="POST"
					modelAttribute="instrument">
					<div class="form-group">
						<div class="row">
							<div class="col">
								<form:label path="name">Name</form:label>
								<form:errors path="name" style="color:red"/>
								<form:input path="name" class="form-control" required="true" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:label path="price">Price</form:label>
								<form:errors path="price" style="color:red"/>
								<form:input path="price" class="form-control" required="true" />
							</div>
							<div class="col">
								<form:label path="type">Type</form:label>
								<form:errors path="type" style="color:red"/>
								<form:input path="type" class="form-control" required="true" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:label path="brand">Brand</form:label>
								<form:errors path="brand" style="color:red"/>
								<form:input path="brand" class="form-control" required="true"/>
							</div>
						</div>
					</div>
					<div class="row mt-3">
						<button type="submit" class="btn btn-primary">Add Instrument</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<form:input path="category" type="hidden" value="INSTRUMENT" />
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>