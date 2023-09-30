package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.enums.ProductStatus;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ProductReponsitory {
    private EntityManager em ;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductReponsitory(){
        em = ConnectDB.getConnectDB().getEmf().createEntityManager();
    }

    public boolean addProduct(Product product){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(product);
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean updateProduct(Product product){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean deleteProduct(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(getProductById(id));
            tr.commit();
            return true;
        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.commit();
        }
        return false;
    }
    public Optional<Product> getProductById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Product product = em.find(Product.class, id);
            tr.commit();
            return Optional.of(product);

        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return Optional.empty();
    }
    public List<Product> getAll(){
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            List<Product> productList = em.createNativeQuery("SELECT * FROM product", Product.class).getResultList();

            tr.commit();
            return productList;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
            return Collections.emptyList();
        }
    }
    public List<Product> getAllProductsWithImages() {
       EntityTransaction tr = em.getTransaction();
        try {
            TypedQuery<Product> query = em.createQuery(
                    "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.productImageList", Product.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Product> getAllProductsWithImagesAndPrices() {
        TypedQuery<Product> query = em.createQuery("SELECT DISTINCT p FROM Product p " +
                "LEFT JOIN FETCH p.productPrices", Product.class);

        List<Product> products = query.getResultList();


        for (Product product : products) {
            Hibernate.initialize(product.getProductImageList());
        }

        return products;
    }


    public void setStatus(Product product, ProductStatus productStatus){
        product.setStatus(productStatus);
    }
    public List<Product> getActiveProduct(){
        return em.createNamedQuery("Product.findAll", Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }
    public void updateStatus(long id, ProductStatus productStatus){
        EntityTransaction tr = em.getTransaction();
        TypedQuery<Product> query = em.createNamedQuery("Product.findById", Product.class)
                .setParameter(1, id);
        Product product = query.getSingleResult();
        product.setStatus(productStatus);
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            logger.info(e.getMessage());
        }
    }
//  public List<Product> getAllProductWithPrices(){
//        EntityTransaction tr = em.getTransaction();
//        List<Product> productList = new ArrayList<>();
//
//        try {
//            String jpql = "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.productImageList";
//            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
//            List<Product> products = query.getResultList();
//
//            for (Product product : products) {
//                String priceJpql = "SELECT pp FROM ProductPrice pp WHERE pp.id = :productId ORDER BY pp.priceDateTime DESC";
//                TypedQuery<ProductPrice> priceQuery = em.createQuery(priceJpql, ProductPrice.class);
//                priceQuery.setParameter("productId", product.getId());
//                priceQuery.setMaxResults(1);
//                List<ProductPrice> prices = priceQuery.getResultList();
//
//                if (!prices.isEmpty()) {
//                    ProductPrice latestPrice = prices.get(0);
//                    product.setPrice(latestPrice.getPrice());
//                }
//
//                productsWithPrices.add(product);
//        }
//  }
}
