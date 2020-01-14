package kg.easy.shop.services.impl;

import kg.easy.shop.dao.SupplierPhoneRepo;
import kg.easy.shop.dao.SupplierRepo;
import kg.easy.shop.dao.UserStatusRepo;
import kg.easy.shop.models.Supplier;
import kg.easy.shop.models.SupplierPhone;
import kg.easy.shop.models.UserStatus;
import kg.easy.shop.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserStatusRepo userStatusRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private SupplierPhoneRepo supplierPhoneRepo;

    @Override
    public UserStatus saveUserStatus(UserStatus userStatus) {

        return userStatusRepo.save(userStatus);
    }

    @Override
    public List<UserStatus> getAllUserStatuses() {
        return userStatusRepo.findAll();
    }

    @Override
    public Supplier saveSupllier(Supplier supplier) {
        supplier = supplierRepo.save(supplier);


        List<SupplierPhone> phones = supplier.getPhones();
        Supplier finalSupplier = supplier;

        phones.stream()
                .forEach(x -> x.setSupplier(finalSupplier));

        supplier.setPhones(supplierPhoneRepo.saveAll(phones));


        return supplier;
    }

    @Override
    public List<Supplier> getAllSuppliers() {

        List<Supplier> suppliers = supplierRepo.findAll();

        suppliers.stream()
                .forEach(x->x.setPhones(supplierPhoneRepo.findAllBySupplier(x)));


        return suppliers;
    }
}
