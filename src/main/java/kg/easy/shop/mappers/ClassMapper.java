package kg.easy.shop.mappers;

import kg.easy.shop.models.dto.*;
import kg.easy.shop.models.entities.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Operation OperationDtoToOperation(OperationDto operationDto);
    @InheritInverseConfiguration
    OperationDto OperationToOperationDto(Operation operation);

    UserStatus userStatusDtoToUserStatus(UserStatusDto userStatusDto);
    @InheritInverseConfiguration
    UserStatusDto userStatusToUserStatusDto(UserStatus userStatus);

    List<UserStatusDto> userStatusesToUserStatusDtos(List<UserStatus> userStatuses);
    @InheritInverseConfiguration
    List<UserStatus> userStatusDtosToUserStatuses(List<UserStatusDto> userStatusDtos);

    User userDtoToUser(UserDto userDto);
    @InheritInverseConfiguration
    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);
    @InheritInverseConfiguration
    List<User> userDtosToUsers(List<UserDto> userDtos);

    Supplier supplierDtoToSupplier(SupplierDto supplierDto);
    @InheritInverseConfiguration
    SupplierDto supplierToSupplierDto(Supplier supplier);

    List<SupplierDto> suppliersToSupplierDtos(List<Supplier> suppliers);
    @InheritInverseConfiguration
    List<Supplier> supplierDtosToSupplier(List<SupplierDto> supplierDtos);

    List<SupplierPhoneDto> supplierPhonesToSupplierPhoneDtoes(List<SupplierPhone> supplierPhones);
    @InheritInverseConfiguration
    List<SupplierPhone> supplierPhoneDtosToSupplierPhones(List<SupplierPhoneDto> supplierPhoneDtos);

    Customer customerDtoToCustomer(CustomerDto customerDto);
    @InheritInverseConfiguration
    CustomerDto customerToCustomerDto(Customer customer);

    List<CustomerDto> customerToCustomerDtos(List<Customer> customers);
    @InheritInverseConfiguration
    List<Customer> customerDtoToCustomers(List<CustomerDto> customerDtos);

    List<CustomerPhoneDto> customerPhonesToCustomerPhoneDtos(List<CustomerPhone> customerPhones);
    @InheritInverseConfiguration
    List<CustomerPhone> customerPhoneDtosToCustomerPhones(List<CustomerPhoneDto> customerPhoneDtos);

    Product productDtoToProduct(ProductDto productDto);
    @InheritInverseConfiguration
    ProductDto productToProductDto(Product product);

    Income incomeDtoToIncome(IncomeDto incomeDto);
    @InheritInverseConfiguration
    IncomeDto incomeToIncomeDto(Income income);

    ProductCategory productCategoryDtoToProductcategory(ProductCategoryDto productCategoryDto);
    @InheritInverseConfiguration
    ProductCategoryDto productCategoryToProductcategoryDto(ProductCategory productCategory);


}
