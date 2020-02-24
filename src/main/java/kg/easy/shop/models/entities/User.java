package kg.easy.shop.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String login;
    private String pwd;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private UserStatus status;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserPhone> phones;
}