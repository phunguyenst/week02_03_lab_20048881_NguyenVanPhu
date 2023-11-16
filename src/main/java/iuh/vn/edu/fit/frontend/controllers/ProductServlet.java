package iuh.vn.edu.fit.frontend.controllers;

import iuh.vn.edu.fit.backend.enums.ProductStatus;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.ProductServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/ProductControl")
public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Kiểm tra hành động là thêm sản phẩm
        if ("add".equals(action)) {
            addProduct(request, response);
        }
        // Kiểm tra hành động là sửa sản phẩm
        else if ("edit".equals(action)) {
            editProduct(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Kiểm tra hành động là xóa sản phẩm
        if ("delete".equals(action)) {
            deleteProduct(request, response);
        }
        else if ("edit".equals(action)) {
            editProduct(request, response);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ request
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String unit = request.getParameter("unit");
        String manufacturerName = request.getParameter("manufacturerName");
        String status = request.getParameter("status");
        ProductStatus productStatus = null;
        if (status.equals("-1"))
            productStatus = ProductStatus.TERMINATED;
        else if (status.equals("0"))
            productStatus = ProductStatus.IN_ACTIVE;
        else productStatus = ProductStatus.ACTIVE;

        // Tạo đối tượng Product
        Product product = new Product(name, description, unit, manufacturerName, productStatus);

        // Gọi phương thức thêm sản phẩm từ service hoặc repository
        ProductServices productServices = new ProductServices();
        productServices.addProduct(product);

        // Chuyển hướng về trang hiển thị sản phẩm
        response.sendRedirect("CRUDProduct.jsp");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ request
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String unit = request.getParameter("unit");
        String manufacturerName = request.getParameter("manufacturerName");
        String status = request.getParameter("status");
        ProductStatus productStatus = null;
        if (status.equals("-1"))
            productStatus = ProductStatus.TERMINATED;
        else if (status.equals("0"))
            productStatus = ProductStatus.IN_ACTIVE;
        else productStatus = ProductStatus.ACTIVE;

        // Tạo đối tượng Product
        Product product = new Product(id, name, description, unit, manufacturerName, productStatus);

        // Gọi phương thức sửa sản phẩm từ service hoặc repository
        ProductServices productServices = new ProductServices();
        productServices.updateProduct(product);

        // Chuyển hướng về trang hiển thị sản phẩm
        response.sendRedirect("CRUDProduct.jsp");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("id"));

        ProductServices productServices = new ProductServices();
        Optional<Product> existingProductOptional  = productServices.getProductById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            existingProduct.setStatus(ProductStatus.TERMINATED);
            productServices.updateProduct(existingProduct);
        }

        response.sendRedirect("CRUDProduct.jsp");
    }
}
