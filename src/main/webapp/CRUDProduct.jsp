<%@ page import="iuh.vn.edu.fit.backend.services.ProductServices" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.vn.edu.fit.backend.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/27/2023
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Manager product</title>
</head>
<body>
<%
    ProductServices productServices = new ProductServices();
    List<Product> lst = productServices.getActiveProduct();
%>
    <div class="container">
        <table class="table table-hover">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Unit</td>
                    <td>Manufacturer_name</td>
                    <td>status</td>
                    <th colspan="2"><a href="insertProduct.jsp">thêm sản phẩm</a></th>
                </tr>
                <%
        for (Product products: lst) {
            long id = products.getId();
            String delete = "ProductControl?action=delete&id=" + id;
            String update = "ProductControl?action=update&id=" + id;
                %>
                    <tr>
                        <td><%=id%></td>
                        <td><%=products.getName()%></td>
                        <td><%=products.getDescription()%></td>
                        <td><%=products.getUnit()%></td>
                        <td><%=products.getManufacturerName()%></td>
                        <td><%=products.getStatus()%></td>
                        <td><a href=<%=update%>>update</a></td>
                        <td><a href=<%=delete%>>delete</a></td>
                    </tr>

                <%
                    }
                %>

            </thead>
        </table>
    </div>
</body>
</html>
