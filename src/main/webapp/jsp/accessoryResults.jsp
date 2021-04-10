<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Accessory Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.2.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    <style>
        img{
          display:block;
          margin-left: auto;
          margin-right: auto;
        }
        body{
          background-color: aliceblue;
        }
      </style>

</head>
<body>

 <%@ include file = "navbar.jsp" %>
<div>
		
	</div>
	<div>
		<table class="table">
			<!-- here should go some titles... -->
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Type</th>
				<th>Brand</th>
			</tr>
			<c:forEach items="${accessoryResults}" var="accessory">
				<tr>
					<td><c:out value="${accessory.getId()}" /></td>
					<td><c:out value="${accessory.getName()}" /></td>
					<td><c:out value="${accessory.getCategory()}" /></td>
					<td><c:out value="${accessory.getPrice()}" /></td>
					<td><c:out value="${accessory.getType()}" /></td>
					<td><c:out value="${accessory.getBrand()}" /></td>
					<td><form action="/cart/add" method="post">
							<button type="submit" class="btn btn-primary">Select</button>
							<input type="hidden" name="id" value="${accessory.getId()}" />
							<input type="hidden" name="table" value="${accessoryResults}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<input type="hidden" name="view" value="accessory" />
							
							
						</form></td>
					<td><form action="/home/deleteTask" method="POST">
							<button type="submit" class="btn btn-primary">Delete</button>
							<input type="hidden" name="taskId" value="${accessory.getId()}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
				</tr>
			</c:forEach>
		</table>
	</div>
<!-- Footer -->
	<footer class="page-footer font-small indigo">
    
        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">Music Store 1234 Broadway St., San Antonio TX. � 2018 Copyright
        </div>
        <!-- Copyright -->
    
      </footer>
	<!-- Footer -->
</body>
</html>