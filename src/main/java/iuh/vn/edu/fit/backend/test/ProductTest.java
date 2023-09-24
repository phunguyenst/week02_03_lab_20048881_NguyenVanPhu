package iuh.vn.edu.fit.backend.test;

import iuh.vn.edu.fit.backend.repositories.ProductReponsitory;

public class ProductTest {
    public static void main(String[] args) {
 //       ProductReponsitory productReponsitory = new ProductReponsitory();
//        ProductService service = new ProductService(productReponsitory);

        ProductReponsitory productReponsitory = new ProductReponsitory();
        System.out.println(productReponsitory.getAll().get(0));



    }
}
