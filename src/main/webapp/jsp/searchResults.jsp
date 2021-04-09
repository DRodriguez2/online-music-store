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
        <td>${product.type}</td>
        <td>${product.name}</td>
        <td>${product.category}</td>      
        <td>${product.price}</td>
    </tr>
  </c:forEach>
</table>


</body>
</html>