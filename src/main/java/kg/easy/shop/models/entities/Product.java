package kg.easy.shop.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private long minAmount;
    private long maxAmount;
    private long amount;
    @OneToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    private boolean active;

    @Transient
    private Price price;
}
