package kg.easy.shop.models.dto;

import lombok.Data;

@Data
public class IncomeDto {
    private Long id;

    private double sum;
    private SupplierDto supplierDto;
}
