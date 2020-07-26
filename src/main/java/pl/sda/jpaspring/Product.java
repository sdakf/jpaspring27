package pl.sda.jpaspring;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String productName;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product() {
    }

    public Product(String isbn, String productName, ProductType productType) {
        this.isbn = isbn;
        this.productName = productName;
        this.productType = productType;
    }
}
