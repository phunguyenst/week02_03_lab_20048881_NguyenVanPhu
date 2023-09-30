package iuh.vn.edu.fit.backend.services;


import iuh.vn.edu.fit.backend.enums.ProductStatus;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.repositories.ProductReponsitory;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductServices {
    @Inject
    private ProductReponsitory productReponsitory;


    @Inject
    public ProductServices(){
        productReponsitory = new ProductReponsitory() ;
    }
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

    public void setStatus(Product product, ProductStatus productStatus){
        productReponsitory.setStatus(product, productStatus);
    }
    public List<Product> getActiveProduct(){
        return productReponsitory.getActiveProduct();
    }
    public void updateStatus(long id, ProductStatus productStatus){
        productReponsitory.updateStatus(id, productStatus);
    }

    public List<Product> getAllProductsWithImagesAndPrices(){
        return productReponsitory.getAllProductsWithImagesAndPrices();
    }
    public List<Product> getAllProductsWithImages() {
        return productReponsitory.getAllProductsWithImages();
    }



}
