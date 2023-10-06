<%@ page import="java.util.ArrayList" %>
<%@ page import="iuh.vn.edu.fit.backend.models.Cart" %>
<%@ page import="iuh.vn.edu.fit.backend.services.ProductServices" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/5/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>

    <style>
        .table tbody td{
            vertical-align: middle;
        }
        .btn-incre, .btn-decre{
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
    <%
        ProductServices productServices = new ProductServices();
        List<Cart> cartProduct = null;
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if(cart_list != null){
            cartProduct = productServices.getCartProducts(cart_list);
            request.setAttribute("card_list", cart_list);
        }
    %>
    <div class="container">
        <div class = "d-flex py-3">
            <h3>Total Price: $452</h3>
            <a class="mx-3 btn btn-primary" href="#">Check Out</a>
        </div>
        <table class="table table-loght">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Buy Now</th>
                <th scope="col">Cancle</th>
            </tr>
            </thead>
            <tbody>
            <%if(cart_list != null){
                for(Cart c: cartProduct){%>
                    <tr>
                <td><%=c.getName()%></td>
                <td><%=c.getUnit()%></td>
                <td><%=c.getTotalPrice()%></td>
                <td>
                    <form action="" method="post" class="form-inline">
                        <input type="hidden" name ="id" value="<%=c.getId()%>" class="form-input">
                        <div class="form-group d-flex justify-content-between">
                            <a class="btn btn-sm btn-incre"><i class = "fas fa-plus-square"></i></a>
                            <input type="text" name="quantity" class="form-control" value="1" readonly>
                            <a class="btn btn-sm btn-decre"><i class = "fas fa-minus-square"></i></a>

                        </div>
                    </form>
                </td>
                <td><a class="btn btn-sm btn-danger" href="">Remove</a> </td>
            </tr>
               <% }
            }
%>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
