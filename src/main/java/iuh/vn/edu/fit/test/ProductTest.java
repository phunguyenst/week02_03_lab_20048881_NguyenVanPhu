package iuh.vn.edu.fit.test;

import iuh.vn.edu.fit.models.Product;
import iuh.vn.edu.fit.repositories.ProductReponsitory;
import iuh.vn.edu.fit.services.ProductService;

public class ProductTest {
    public static void main(String[] args) {
 //       ProductReponsitory productReponsitory = new ProductReponsitory();
//        ProductService service = new ProductService(productReponsitory);

        ProductReponsitory productReponsitory = new ProductReponsitory();
        System.out.println(productReponsitory.getAll().get(0));



    }
}
