package kg.easy.shop.models.dto;

import lombok.Data;

@Data
public class SupplierPhoneDto {
    private Long id;

    private String phone;
    private boolean active;

    private SupplierDto supplier;
}
