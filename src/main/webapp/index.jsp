<%@ page import="iuh.vn.edu.fit.repositories.ProductReponsitory" %>
<%@ page import="iuh.vn.edu.fit.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.vn.edu.fit.models.ProductImage" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="hello-servlet" method="get">
    <input type="hidden" name="action" value="MappingTable">
    <input name="MappingTable" type="submit" value="MappingTable">

</form>

<%--<a href="all-products.jsp">getAllProduct</a>--%>
<form action="hello-servlet" method="get">
    <input type="hidden" name="action" value="allproduct">
    <input name="allproduct" type="submit" value="allproduct">
</form>
</body>
</html>