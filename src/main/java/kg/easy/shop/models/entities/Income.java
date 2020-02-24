package kg.easy.shop.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "incomes")
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double sum;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
