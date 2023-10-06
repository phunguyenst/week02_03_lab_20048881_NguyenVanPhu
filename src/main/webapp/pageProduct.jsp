<%@ page import="iuh.vn.edu.fit.backend.models.Product" %>
<%@ page import="iuh.vn.edu.fit.backend.services.ProductServices" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/27/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">


</head>
<body>
    <%
        ProductServices productServices = new ProductServices();
        List<Product> lst = productServices.getAll();
    %>
    <div class="container">
        <a class="btn btn-primary btn-sm" href="CRUDProduct.jsp">Quản lý sản phẩm</a>
        <a class="btn btn-primary btn-sm" href="cart.jsp">Xem giỏ hàng</a>
        <div class="card-header my-3">Danh sách sản phẩm</div>
        <div class="row">
            <%
                if(!lst.isEmpty()){
                    int i = 0;
                    for (Product p: lst) {%>
                        <div class="col-md-3 my-3">
                            <div class="card w-100" style="width: 18rem;">
                                <img class="card-img-top" src="<%=p.getProductImageList().get(i).getPath()%>" alt="Card image cap">
                                <div class="card-body card">
                                    <h5 class="card-title"><%=p.getName()%></h5>
                                    <h6 class="price"><%=p.getProductPrices().get(0).getPrice()%></h6>
                                    <h6 class="Manu"><%=p.getManufacturerName()%></h6>
                                    <div class="mt-3 d-flex justify-content-between">
                                        <a href="add-to-cart?id=<%=p.getId()%>" class="btn btn-dark">Add cart</a>
                                        <a href="#" class="btn btn-primary">Buy</a>
                                    </div>
                                </div>
                            </div>
                        </div>
            <%}
                i++;
            }
            %>
        </div>
    </div>






    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
