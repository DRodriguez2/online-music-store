<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<%@ include file = "navbar.jsp" %>

<title>Homepage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>

	<%@ include file="navbar.jsp"%>
	<div class="container mt-3">
		<h1>ADMIN PAGE</h1>
	</div>
	

	<div class="row">
		<div class="col-2">
			<div class="row" style="height: 40%">a</div>
			<div class="row float-end">
				<ul class="nav flex-column">
					<li class="nav-item">
						<form action="/admin" method="GET">
							<button type="submit" class="btn btn-link" >Music</button>
							<input type="hidden" name="category" value="music" />
						</form>
					</li>
					<li class="nav-item">
						<form action="/admin" method="GET">
							<button type="submit" class="btn btn-link">Instruments</button>
							<input type="hidden" name="category" value="instrument" />
						</form>
					</li>
					<li class="nav-item">
						<form action="/admin" method="GET">
							<button type="submit" class="btn btn-link">Services</button>
							<input type="hidden" name="category" value="service" />
						</form>
					</li>
					<li class="nav-item">
						<form action="/admin" method="GET">
							<button type="submit" class="btn btn-link">Accessories</button>
							<input type="hidden" name="category" value="accessory" />
						</form>
					</li>
				</ul>
			</div>
		</div>

		<div class="col-8 table-responsive">

			<c:choose>
				<c:when test="${category.equals('music')}">
					<%@ include file="adminMusicView.jsp"%>
				</c:when>
				<c:when test="${category.equals('instrument')}">
					<%@ include file="adminInstrumentView.jsp"%>
				</c:when>
				<c:when test="${category.equals('service')}">
					<%@ include file="adminServicesView.jsp"%>
				</c:when>
				<c:when test="${category.equals('accessory')}">
					<%@ include file="adminAccessoriesView.jsp"%>
				</c:when>
			</c:choose>

		</div>
		<div class="col-2"></div>
	</div>


	<div class="row mt-2">
		<div class="col-2"></div>
		<div class="col-8">
			<div class="row justify-content-center">
				<div class="col-6">
					<c:choose>
						<c:when test="${editCategory.equals('song')}">
							<%@ include file="adminSongTask.jsp"%>
						</c:when>
						<c:when test="${editCategory.equals('album')}">
							<%@ include file="adminAlbumTask.jsp"%>
						</c:when>
						<c:when test="${editCategory.equals('instrument')}">
							<%@ include file="adminInstrumentTask.jsp" %>
						</c:when>
						<c:when test="${editCategory.equals('service')}">
							<%@ include file="adminServicesTask.jsp" %>
						</c:when>
						<c:when test="${editCategory.equals('accessory')}">
							<%@ include file="adminAccessoryTask.jsp" %>
						</c:when>
					</c:choose>
				</div>
				<div class="col-6">
					<c:if test="${addCategory != null }">
						<c:choose>
							<c:when test="${numSongs > 0 }">
								<%@ include file="adminAddSong.jsp" %>
							</c:when>
							<c:when test="${addCategory.equals('album')}">
								
								<%@ include file="adminAddAlbum.jsp" %>
							</c:when>
							<c:when test="${addCategory.equals('song')}">
								<%@ include file="adminAlbumTask.jsp"%>
							</c:when>
							<c:when test="${addCategory.equals('instrument')}">
								<%@ include file="adminAddInstrument.jsp" %>
							</c:when>
							<c:when test="${addCategory.equals('service')}">
								<%@ include file="adminAddService.jsp" %>
							</c:when>
							<c:when test="${addCategory.equals('accessory')}">
								<%@ include file="adminAddAccessory.jsp" %>
							</c:when>
						</c:choose>
					</c:if>
				</div>
				
				
			</div>	
		</div>
		<div class="col-2"></div>
	</div>


</body>


</html>