package kg.easy.shop.models.dto;

import kg.easy.shop.models.entities.UserStatus;

import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String login;
    private String pwd;

    private UserStatus status;

    private List<UserPhoneDto> userPhoneDtos;
}
