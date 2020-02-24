package kg.easy.shop.services.common.impl;

import kg.easy.shop.dao.OperationDetailRepository;
import kg.easy.shop.dao.OperationRepository;
import kg.easy.shop.enums.OperationType;
import kg.easy.shop.models.entities.Operation;
import kg.easy.shop.models.entities.OperationDetail;
import kg.easy.shop.models.entities.Product;
import kg.easy.shop.models.entities.User;
import kg.easy.shop.models.data.Detail;
import kg.easy.shop.models.data.SellOperation;
import kg.easy.shop.services.common.OperationService;
import kg.easy.shop.services.common.ProductService;
import kg.easy.shop.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationDetailRepository operationDetailRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @Override
    public SellOperation saveOperation(SellOperation sellOperation) {

        List<Detail> details = sellOperation.getDetails();

        System.out.println(sellOperation.getUserId());

        User user = userService.findUserById(sellOperation.getUserId());

        List<Long> prices = details.stream().map(x-> {
            long amount = x.getAmount();

            Product product = productService.getProductById(x.getProductId());

            if (product.getAmount() < x.getAmount()) {
                throw new RuntimeException("Не хватает товара " + product.getName());
            }

            long price = product.getPrice().getPrice();

            return amount * price;

        }).collect(Collectors.toList());

        long total = prices.stream().collect(Collectors.summarizingLong(Long::longValue)).getSum();


        if (total > sellOperation.getSum()) {
            throw new RuntimeException("Недостаточно дене");
        }


        Operation operation = new Operation();
        operation.setFactSum(sellOperation.getSum());
        operation.setOperationDate(new Date());
        operation.setOperationType(OperationType.SELL);
        operation.setUser(user);
        operation.setTotal(total);
        operation = operationRepository.save(operation);

        Operation finalOperation = operation;

        details.forEach(x-> {
            OperationDetail operationDetail = new OperationDetail();

            Product product = productService.getProductById(x.getProductId());

            operationDetail.setProduct(product);
            operationDetail.setOperation(finalOperation);
            operationDetail.setAmount(x.getAmount());

            operationDetailRepository.save(operationDetail);
        });

        return sellOperation;
    }

    @Override
    public List<Operation> getOperations() {

        return operationRepository.findAll();

    }

    @Override
    public List<OperationDetail> getOperationDetails(Long id) {

        Operation operation = operationRepository.findById(id).orElse(null);

        if (operation == null) {
            throw new RuntimeException("Операции с таким Id не существует!");
        }

        return operationDetailRepository.findAllByOperation(operation);
    }
}
