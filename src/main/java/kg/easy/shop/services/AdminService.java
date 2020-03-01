package kg.easy.shop.services;

import kg.easy.shop.models.dto.*;
import kg.easy.shop.models.entities.*;

import java.util.List;

public interface AdminService {

    UserStatus saveUserStatus(UserStatusDto userStatusDto);

    List<UserStatusDto> getUserStatusList();

    User saveUser(UserDto userDto);

    List<UserDto> getUserList();

    Supplier saveSupplier(SupplierDto supplierDto);

    List<SupplierDto> getSupplierList();

    Customer saveCustomer(CustomerDto customerDto);

    List<CustomerDto> getCustomerList();

    List<UserPhone> getUserPhoneList(Long id);

    Product saveProduct(ProductDto productDto);

    List<Product> getProductList();

    Price savePrice(Price price);

    List<Price> getPriceList();

    Income saveIncome(IncomeDto incomeDto);

    List<Income> getIncomeList();
}