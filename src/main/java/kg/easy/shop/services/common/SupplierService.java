package kg.easy.shop.services.common;

import kg.easy.shop.models.entities.Income;
import kg.easy.shop.models.entities.Supplier;
import kg.easy.shop.models.data.IncomeData;

import java.util.List;

public interface SupplierService {

    Supplier findSupplierById(Long id);

    List<Income> saveIncomeData(List<IncomeData> incomeDataList);

}
