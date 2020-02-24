package kg.easy.shop.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private double balance;
    private float percent = 1;

    @Transient
    private List<CustomerPhone> phones;
}
