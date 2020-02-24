package kg.easy.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private Date startDate;
    @JsonIgnore
    private Date endDate = new Date(Long.MAX_VALUE);
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
}
