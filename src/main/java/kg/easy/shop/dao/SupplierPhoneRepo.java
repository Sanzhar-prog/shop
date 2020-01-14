package kg.easy.shop.dao;

import kg.easy.shop.models.Supplier;
import kg.easy.shop.models.SupplierPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierPhoneRepo extends JpaRepository<SupplierPhone,Long> {

    List<SupplierPhone> findAllBySupplier(Supplier supplier);
}
