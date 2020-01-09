package kg.easy.shop.models;

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

    @OneToMany(mappedBy = "user")
    private List<UserPhone> phones;

}
