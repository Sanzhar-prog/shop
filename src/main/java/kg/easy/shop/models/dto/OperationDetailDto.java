package kg.easy.shop.models.dto;

import lombok.Data;

@Data
public class OperationDetailDto {
    private Long id;
    private Long amount;
    private ProductDto productDto;
}
