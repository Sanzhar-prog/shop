package kg.easy.shop.services;

import kg.easy.shop.models.entities.*;

import java.util.List;

public interface AdminService {

    UserStatus saveUserStatus(UserStatus userStatus);

    List<UserStatus> getUserStatusList();

    User saveUser(User user);

    List<User> getUserList();

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getSupplierList();

    Customer saveCustomer(Customer customer);

    List<Customer> getCustomerList();

    List<UserPhone> getUserPhoneList(Long id);

    Product saveProduct(Product product);

    List<Product> getProductList();

    Price savePrice(Price price);

    List<Price> getPriceList();
}