package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.models.ProductImage;
import org.slf4j.LoggerFactory;

public class ProductImageRepository extends GenericCRUD<ProductImage> {
    public ProductImageRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
