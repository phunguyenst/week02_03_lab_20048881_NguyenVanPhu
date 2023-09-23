package iuh.vn.edu.fit.repositories;

import iuh.vn.edu.fit.models.Product;
import iuh.vn.edu.fit.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepository() {
        this.em = ConnectDB.getConnectDB().getEmf().createEntityManager();
    }
    public  boolean addProductPrice(ProductPrice productPrice){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(productPrice);
            tr.commit();
            return  true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean deleteProductPrice(long productId, LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            ProductPrice productPrice = new ProductPrice(priceDateTime, em.find(Product.class, productId));
        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public Optional<ProductPrice> getProductPriceById(long productId, LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            ProductPrice productPriceId = new ProductPrice(priceDateTime, em.find(Product.class, productId));
            ProductPrice productPrice = em.find(ProductPrice.class, productPriceId);
            tr.commit();
            return Optional.of(productPrice);
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
            return  Optional.empty();
        }
    }
    public List<ProductPrice> getAll(){
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            List<ProductPrice> list = em.createNativeQuery("SELECT * FROM product_price", ProductPrice.class).getResultList();
            tr.commit();
            return list;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
