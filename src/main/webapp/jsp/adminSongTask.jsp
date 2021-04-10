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



		<div class="col">
			<div class="container p-3 my-3 row-full">
				<div class="container">
					<h3>Edit or Delete Song</h3>
					<form action="/admin/task/song" method="POST">
						<div class="form-group">
							<div class="row">
								<div class="col">
									<label>Product Id</label>
									<input class="form-control" name="productId" value="${editSong.getId()}" readonly/>
								</div>
								<div class="col">
									<label>Name</label>
									<input class="form-control" name="name" required value="${editSong.getName()}" />
								</div>
							</div>

							<div class="row">
								<div class="col">
									<label>Price</label>
									<input class="form-control" name="price" required value="${editSong.getPrice()}" />
								</div>
								<div class="col">
									<label>Album</label>
									<select class="form-select" name="albumName">
										<option selected value="${editSong.getAlbum().getName()}">${editSong.getAlbum().getName()}</option>
										<c:forEach items="${allAlbums}" var="album">
											<option value="${album.getName()}">${album.getName()}</option>
										</c:forEach>		
									</select>
								</div>

							</div>

							<div class="row">
								<div class="col">
									<label>Artist</label>
									<input class="form-control" name="artist" required value="${editSong.getArtist()}" />
								</div>
								<div class="col">
									<label>Genre</label>
									<input class="form-control" name="genre" required value="${editSong.getGenre()}" />
								</div>
							</div>
						</div>
						<div class="row mt-3">
							<button type="submit" class="btn btn-primary">Submit Changes</button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>

						

					</form>
					<div class="row mt-4">
						<form action="/admin/delete" method="POST">
							<button type="submit" class="btn btn-danger" style="width:100%">Delete Song</button>
							<input type="hidden" name="id" value="${editSong.getId()}" />
							<input type="hidden" name="editCategory" value="${category}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>

				</div>
			</div>
		</div>

</body>
</html>