<%@ page import="iuh.vn.edu.fit.backend.repositories.ProductReponsitory" %>
<%@ page import="iuh.vn.edu.fit.backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.vn.edu.fit.backend.models.ProductImage" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%--    <div class="container">--%>
<%--        <div class="card w-30 mx-auto my-5">--%>
<%--            <div class="card-hearder text-center">User login </div>--%>
<%--            <div class="card-body">--%>
<%--                <form action="" method="post">--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Email Address</label>--%>
<%--                        <input type="email" class="form-control" name="login-email" id="login-email" placeholder="Enter Your Email" required>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Password</label>--%>
<%--                        <input type="password" class="form-control" name="login-password" id="login-password" placeholder="********" required>--%>
<%--                    </div>--%>
<%--                    <div class="text-center">--%>
<%--                       <button type="submit" class="btn btn-primary">Login</button>--%>
<%--                     </div>--%>

<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<a href="pageEmployee.jsp">quản lý nhân viên</a>
<a href="pageCustomer.jsp">quản lý sản phẩm</a>
<a href="pageProduct.jsp">danh sách sản phẩm</a>

</body>
</html>