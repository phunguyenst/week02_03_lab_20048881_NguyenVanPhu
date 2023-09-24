package iuh.vn.edu.fit.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    //product_image (product_id, image_id, path, alternative)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", columnDefinition = "bigint(20)")
    private long image_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String alternative;

    private String path;

    public ProductImage() {
    }

    public ProductImage(long image_id, Product product, String alternative, String path) {
        this.image_id = image_id;
        this.product = product;
        this.alternative = alternative;
        this.path = path;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "image_id=" + image_id +
                ", product=" + product +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
