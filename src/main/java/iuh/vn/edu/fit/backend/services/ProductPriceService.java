package iuh.vn.edu.fit.backend.services;

import iuh.vn.edu.fit.backend.models.ProductPrice;
import iuh.vn.edu.fit.backend.repositories.ProductPriceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceService {

    private ProductPriceRepository productPriceRepository;

    public boolean addProductPrice(ProductPrice productPrice){
        return  productPriceRepository.addProductPrice(productPrice);
    }

    public boolean deleteProductPrice(long productId, LocalDateTime priceDateTime){
        return productPriceRepository.deleteProductPrice(productId, priceDateTime);
    }
    public Optional<ProductPrice> getProductPriceById(long productId, LocalDateTime priceDateTime){
        return productPriceRepository.getProductPriceById(productId, priceDateTime);
    }
    public List<ProductPrice> getAll(){
        return  productPriceRepository.getAll();
    }






}
