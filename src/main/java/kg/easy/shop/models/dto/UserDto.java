package kg.easy.shop.models.dto;

import kg.easy.shop.models.entities.UserStatus;
import lombok.Data;

import java.util.List;
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String login;
    private String pwd;

    private UserStatusDto statusDto;

    private List<UserPhoneDto> userPhoneDtos;
}
