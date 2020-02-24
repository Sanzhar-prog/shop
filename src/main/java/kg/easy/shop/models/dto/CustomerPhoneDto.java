package kg.easy.shop.models.dto;

import kg.easy.shop.models.entities.Customer;
import lombok.Data;

@Data
public class CustomerPhoneDto {
    private Long id;
    private String phone;
    private boolean active;
    private Customer customer;
}
