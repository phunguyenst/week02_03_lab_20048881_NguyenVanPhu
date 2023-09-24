<%@ page import="iuh.vn.edu.fit.backend.repositories.ProductReponsitory" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.vn.edu.fit.backend.models.Product" %>
<%@ page import="iuh.vn.edu.fit.backend.models.ProductImage" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/21/2023
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Product</title>
</head>
<body>
    <h1>Danh sách sản phẩm</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Unit</th>
            <th>Manufacturer</th>
            <th>Status</th>
            <th>Images</th>
        </tr>
        </thead>
        <tbody>
<%--            <%--%>
<%--                ProductReponsitory productReponsitory = new ProductReponsitory();--%>
<%--                List<Product> products = productReponsitory.getAllProductsWithImages();--%>
<%--                System.out.println(products);--%>
<%--                for (Product product:products) {--%>
<%--                    System.out.println("xuất "+product);--%>

<%--           %>--%>
<c:forEach items="${products}" var="product">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.unit}</td>
        <td>${product.manufacturerName}</td>
        <td>${product.status}</td>
        <td>
            <ul>
                <c:forEach items="${product.productImageList}" var="image">
                    <li>
                        <img src="${image.path}" alt="${image.alternative}">
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</c:forEach>


<%--            <%--%>
<%--                }--%>
<%--            %>--%>


        </tbody>
    </table>
</body>
</html>
