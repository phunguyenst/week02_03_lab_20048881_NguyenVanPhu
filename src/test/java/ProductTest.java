import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.repositories.ProductReponsitory;

import java.util.List;

public class ProductTest {
    public static void main(String[] args) {
 //       ProductReponsitory productReponsitory = new ProductReponsitory();
//        ProductService service = new ProductService(productReponsitory);

        ProductReponsitory productReponsitory = new ProductReponsitory();
        List<Product> productList = productReponsitory.getAll();
        for (Product p: productList
             ) {
            System.out.println(p);
        }



    }
}
