package kg.easy.shop.models.dto;

import kg.easy.shop.enums.OperationType;
import lombok.Data;

import java.util.List;


@Data
public class OperationDto {

    private Long id;
    private double factSum;
    private OperationType operationType;
    private UserDto userDto;
    private CustomerDto customerDto;
    private IncomeDto incomeDto;
    private List<OperationDetailDto> operationDetailDtos;
}
