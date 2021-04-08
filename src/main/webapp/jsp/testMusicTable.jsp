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

<div>
		<form action="/music/all" method="GET">
			<button type="submit" class="btn btn-primary">get all music</button>
		</form>
	</div>
	<div>
		<table class="table">
			<!-- here should go some titles... -->
			<tr>
				<th>col1</th>
				<th>col2</th>
				<th>col3</th>
				<th>col4</th>
				<th>col5</th>
				<th>col6</th>
				<th>col7</th>
				<th>col8</th>
				<th>col9</th>
				<th>col10</th>
			</tr>
			<c:forEach items="${musicList}" var="music">
				<tr>
					<td><c:out value="${music.getId()}" /></td>
					<td><c:out value="${music.getName()}" /></td>
					<td><c:out value="${music.getCategory()}" /></td>
					<td><c:out value="${music.getPrice()}" /></td>
					<td><c:out value="${music.getPlatform()}" /></td>
					<td><c:out value="${music.getType()}" /></td>
					<td><c:out value="${music.getArtist()}" /></td>
					<td><c:out value="${music.getGenre()}" /></td>
					<td><form action="/home/edit">
							<button type="submit" class="btn btn-primary">Select</button>
							<input type="hidden" name="taskId" value="${music.getId()}" />
						</form></td>
					<td><form action="/home/deleteTask" method="POST">
							<button type="submit" class="btn btn-primary">Delete</button>
							<input type="hidden" name="taskId" value="${music.getId()}" /><input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>