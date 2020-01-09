package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "incomes")
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long sum;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
