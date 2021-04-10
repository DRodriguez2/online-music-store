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
				<h3>Create Album</h3>
				<form:form action="/admin/addAlbum" method="POST"
					modelAttribute="music">
					<div class="form-group">
						<div class="row">
							<div class="col">
								<form:label path="name">Name</form:label>
								<form:errors path="name" style="color:red"/>
								<form:input path="name" class="form-control" required="true" />
							</div>
							<div class="col">
								<form:label path="price">Price</form:label>
								<form:errors path="price" style="color:red"/>
								<form:input path="price" class="form-control" required="true" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:label path="platform">Platform</form:label>
								<form:errors path="platform" style="color:red"/>
								<form:select path="platform" class="form-select">
									<form:option value="DIGITAL">Digital</form:option>
									<form:option value="PHYSICAL">Physical</form:option>
								</form:select>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<form:label path="genre">Genre</form:label>
								<form:errors path="genre" style="color:red"/>
								<form:input path="genre" class="form-control" required="true" />
							</div>
							<div class="col">
								<form:label path="artist">Artist</form:label>
								<form:errors path="artist" style="color:red"/>
								<form:input path="artist" class="form-control" required="true"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label>Number of songs (1 for single) <c:out value="${numSongsError}"/> </label> 
								<input class="form-control" name="numSongs" />
							</div>
						</div>

					</div>
					<div class="row mt-3">
						<button type="submit" class="btn btn-primary">Submit Changes</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<form:input path="type" type="hidden" value="ALBUM" />
						<form:input path="category" type="hidden" value="MUSIC" />
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>