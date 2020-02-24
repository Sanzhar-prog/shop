package kg.easy.shop.models.dto;

import kg.easy.shop.models.entities.User;
import lombok.Data;

@Data
public class UserPhoneDto {
    private Long id;
    private String phone;
    private boolean active;
    private User user;
}
