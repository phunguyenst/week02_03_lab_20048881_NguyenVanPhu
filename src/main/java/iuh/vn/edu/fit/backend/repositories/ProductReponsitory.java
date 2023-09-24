package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

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
        }
        return null;
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

}
