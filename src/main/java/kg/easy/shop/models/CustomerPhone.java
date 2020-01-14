package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_phones")
public class CustomerPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phone;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
