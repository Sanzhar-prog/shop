package kg.easy.shop.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PriceDto {
    private Long id;
    private long price;
    private Date startDate;
    private Date endDate = new Date(Long.MAX_VALUE);
}
