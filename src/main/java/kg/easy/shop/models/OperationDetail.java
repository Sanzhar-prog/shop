package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "operation_details")
public class OperationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long amount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

}
