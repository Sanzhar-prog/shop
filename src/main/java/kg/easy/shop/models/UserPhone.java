package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_phones")
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean active;

}
