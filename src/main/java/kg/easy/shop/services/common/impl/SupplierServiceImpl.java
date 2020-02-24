package kg.easy.shop.services.common.impl;

import kg.easy.shop.dao.SupplierRepository;
import kg.easy.shop.models.entities.Income;
import kg.easy.shop.models.entities.Supplier;
import kg.easy.shop.models.data.IncomeData;
import kg.easy.shop.services.common.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;


    @Override
    public Supplier findSupplierById(Long id) {

        Supplier supplier = supplierRepository.findById(id).orElse(null);

        if(supplier == null) {
            throw new RuntimeException("Поставшик не существует");
        }

        return supplier;
    }

    @Override
    public List<Income> saveIncomeData(List<IncomeData> incomeDataList) {

        List<Income> incomes = incomeDataList.stream()
                .filter(x-> x.getSum() > 100).map(x -> {

                   Supplier supplier = findSupplierById(x.getSupplierId());

                    Income income = new Income();
                    income.setSum(x.getSum());
                    income.setSupplier(supplier);
                    return income;
                }
        ).collect(Collectors.toList());

        return incomes;
    }
}
