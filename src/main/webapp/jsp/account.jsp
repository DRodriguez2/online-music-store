<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.HCL.Capstone.onlinemusicstore.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<%@ include file = "navbar.jsp" %>

<title>Account Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"/>
	

<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
  rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
 <div class="container">
    <div class="row">
    	<div class="col table-responsive" >
    		<table class="table table-sm table-striped table-bordered" >
			<!-- here should go some titles... -->

			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Credit Card</th>
			</tr>
			
			<%User std = (User) request.getSession().getAttribute("user");%>
            <tr>
                <td><%=std.getUN()%></td>
                <td><%=std.getPass()%></td>
                <td><%=std.getCard()%></td>
            </tr>
			
			
		</table>

    	</div>
    </div>
      
 </div>
 


	<!-- Footer -->
	<footer class="page-footer font-small indigo"> </footer>
	<!-- Footer -->

</body>
</html>