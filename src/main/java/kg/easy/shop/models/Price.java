package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long price;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
