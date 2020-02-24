package kg.easy.shop.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_details")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean active;
}
