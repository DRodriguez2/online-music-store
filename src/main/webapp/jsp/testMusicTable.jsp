<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div  style="display: flex; justify-content: space-between; max-width: 300px; padding: 10px 0;">
		<form action="/music/all" method="GET">
			<button type="submit" class="btn btn-primary">All Music</button>
		</form>

		<form action="/music/songs/all" method="GET">
			<button type="submit" class="btn btn-primary">Songs</button>
		</form>

		<form action="/music/albums" method="GET">
			<button type="submit" class="btn btn-primary">Albums</button>
		</form>
		
	</div>
	
	
	<div>
		<table class="table">
			<!-- here should go some titles... -->
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Platform</th>
				<th>Type</th>
				<th>Artist</th>
				<th>Genre</th>
				<th> </th>
				<th> </th>
			</tr>
			<c:forEach items="${searchResults}" var="music">
				<tr>
					<td><c:out value="${music.getId()}" /></td>
					<td><c:out value="${music.getName()}" /></td>
					<td><c:out value="${music.getCategory()}" /></td>
					<td><c:out value="${music.getPrice()}" /></td>
					<td><c:out value="${music.getPlatform()}" /></td>
					<td><c:out value="${music.getType()}" /></td>
					<td><c:out value="${music.getArtist()}" /></td>
					<td><c:out value="${music.getGenre()}" /></td>

					<td><form action="/cart/add" method="post">
							<button type="submit" class="btn btn-primary">Add to Cart</button>
							<input type="hidden" name="id" value="${music.getId()}" />
							<input type="hidden" name="table" value="${searchResults}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<input type="hidden" name="view" value="music" />
						</form></td>

				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>