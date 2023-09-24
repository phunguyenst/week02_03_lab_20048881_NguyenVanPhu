package iuh.vn.edu.fit.backend.services;


import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.repositories.ProductReponsitory;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Inject
    private ProductReponsitory productReponsitory;

    public boolean addProduct(Product product){
     return productReponsitory.addProduct(product);
    }
    public boolean updateProduct(Product product){
        return  productReponsitory.updateProduct(product);
    }
    public boolean deleteProduct(long id){
      return productReponsitory.deleteProduct(id);
    }
    public Optional<Product> getProductById(long id){
        return productReponsitory.getProductById(id);
    }
    public List<Product> getAll(){
        return productReponsitory.getAll();
    }


}
