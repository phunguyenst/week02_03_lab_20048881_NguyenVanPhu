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
<%--    <H1>danh sách sản phẩm</H1>--%>

<%--    <table class="table talbe-striped">--%>
<%--        <thead>--%>
<%--            <tr>--%>
<%--                <th>Tên sản phẩm</th>--%>
<%--                <th>Hình ảnh</th>--%>
<%--                <th>Giá</th>--%>
<%--                <th>Số sản phẩm thêm vào</th>--%>
<%--            </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--            <%--%>
<%--                for (Product products: lst) {--%>
<%--            %>--%>
<%--            <tr>--%>
<%--                <td><%=products.getName()%></td>--%>
<%--                <td>--%>
<%--                    <%--%>
<%--                        if (!products.getProductImageList().isEmpty()) {--%>
<%--                    %>--%>
<%--                    <img class="img-fluid rounded-circle border-0" src="<%= request.getContextPath() %>/images/<%= products.getProductImageList().get(0).getPath() %>">--%>
<%--                    <%--%>
<%--                        }--%>
<%--                    %>--%>
<%--                </td>--%>
<%--&lt;%&ndash;                <td><%=products.getProductPrices()%></td>&ndash;%&gt;--%>
<%--                <td>--%>
<%--                    <input type="number" name="quantity" id="quantity"value="1">--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <a href="#" class="add-to-cart" data-product-id = <%=products.getId()%>>Thêm vào giỏ hàng</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--             <%--%>
<%--                 }--%>
<%--             %>--%>


<%--        </tbody>--%>
<%--    </table>--%>
<%--    <script>--%>
<%--        $(".add-to-cart").click(function (e){--%>
<%--            e.preventDefault();--%>
<%--            var productId = $(this).data("product-id");--%>
<%--            var quantity = $(this).siblings("input[name = 'quantity']").val();--%>

<%--            $.ajax({--%>
<%--                url: "/add-to.cart",--%>
<%--                type: "POST",--%>
<%--                data:{--%>
<%--                    productId: productId,--%>
<%--                    quantity: quantity--%>
<%--                },--%>
<%--                success: function (){--%>
<%--                    alert("thêm sản phẩm thành công")--%>
<%--                },--%>
<%--                error: function (){--%>
<%--                    alert("thêm thất bại")--%>
<%--                }--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
    <div class="container">
        <div class="card-header my-3">Danh sách sản phẩm</div>
        <div class="row">
            <%
                if(!lst.isEmpty()){
                    for (Product p: lst) {%>
                        <div class="col-md-3 my-3">
                <div class="card w-100" style="width: 18rem;">
                    <img src="<%=p.getProductImageList().get(0).getPath()%>" class="card-img-top" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><%=p.getName()%></h5>
                        <h6 class="price"><%=p.getProductPrices().get(0).getPrice()%></h6>
                        <h6 class="Manu"><%=p.getManufacturerName()%></h6>
                        <div class="d-flex justify-content-between">
                            <a href="#" class="btn btn-primary mb-2 p-2">Add cart</a>
                            <a href="#" class="btn btn-primary mb-2 p-2">Buy</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
                    <%}
                }
            %>



    <a href="CRUDProduct.jsp">Quản lý sản phẩm</a>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
