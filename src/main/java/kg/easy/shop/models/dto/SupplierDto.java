package kg.easy.shop.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class SupplierDto {
    private Long id;
    private String name;
    private String address;
    private List<SupplierPhoneDto> phones;
}
