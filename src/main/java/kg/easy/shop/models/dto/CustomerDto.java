package kg.easy.shop.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String address;
    private double balance;
    private float percent;
    private List<CustomerPhoneDto> phones;
}
