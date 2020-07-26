package pl.sda.jpaspring;

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
}
