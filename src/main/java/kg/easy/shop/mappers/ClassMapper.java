package kg.easy.shop.mappers;

import kg.easy.shop.models.dto.OperationDto;
import kg.easy.shop.models.entities.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassMapper {
    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Operation OperationDtoToOperation(OperationDto operationDto);
    OperationDto OperationToOperationDto(Operation operation);
}
