package iuh.vn.edu.fit.frontend.model;

import iuh.vn.edu.fit.backend.enums.ProductStatus;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.ProductServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductModel {
//    private final ProductServices service = new ProductServices();

//
//    public boolean insertProduct(HttpServletRequest request, HttpServletResponse response){
//
//
//        String name = request.getParameter("name");
//        String desc = request.getParameter("desc");
//        String unit = request.getParameter("unit");
//        String manu = request.getParameter("manu");
//        String status = request.getParameter("status");
//
//
//        Product product = new Product(name, desc, unit, manu, ProductStatus.valueOf(status));
//        boolean check = service.addProduct(product);
//        if(check){
//            return true;
//        }
//        else {
//            return false;
//        }
//
//
//    }
}
