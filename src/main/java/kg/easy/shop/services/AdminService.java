package kg.easy.shop.services;

import kg.easy.shop.models.Supplier;
import kg.easy.shop.models.UserStatus;

import java.util.List;

public interface AdminService {

    UserStatus saveUserStatus(UserStatus userStatus);

    List<UserStatus> getAllUserStatuses();

    Supplier saveSupllier(Supplier supplier);

    List<Supplier> getAllSuppliers();
}
