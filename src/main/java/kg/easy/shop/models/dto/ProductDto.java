package kg.easy.shop.models.dto;

import kg.easy.shop.models.entities.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private long minAmount;
    private long maxAmount;
    private long amount;
    private ProductCategory productCategory;
    private boolean active;
    private PriceDto priceDto;
}
