package kg.easy.shop.services.common;

import kg.easy.shop.models.entities.Operation;
import kg.easy.shop.models.entities.OperationDetail;
import kg.easy.shop.models.data.SellOperation;

import java.util.List;

public interface OperationService {

    SellOperation saveOperation(SellOperation sellOperation);

    List<Operation> getOperations();

    List<OperationDetail> getOperationDetails(Long id);
}
