<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Results</h2>

<table style="float:left">
   <c:forEach items="${product}" var="product" varStatus="count">
    <tr id="${count.index}">
        <td>${product.getType()}</td>
        <td>${product.getName()}</td>
        <td>${product.getCategory()}</td>      
        <td>${product.getPrice()}</td>
    </tr>
  </c:forEach>
</table>

<%@ include file = "footer.jsp" %>
</body>
</html>