import iuh.vn.edu.fit.backend.repositories.ProductReponsitory;

public class Test {
    public static void main(String[] args) {
        ProductReponsitory productReponsitory = new ProductReponsitory();

        System.out.println(productReponsitory.getProductById(2));
    }
}
