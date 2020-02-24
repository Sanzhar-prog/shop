package kg.easy.shop.models.data;

import lombok.Data;

import java.util.List;

@Data
public class SellOperation {

    private List<Detail> details;
    private double sum;
    private Long userId;
}
