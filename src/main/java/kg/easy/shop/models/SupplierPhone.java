package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "supplier_phones")
public class SupplierPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
