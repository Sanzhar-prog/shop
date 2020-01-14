package kg.easy.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_statuses")
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean active;
}
