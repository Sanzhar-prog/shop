package kg.easy.shop.dao;

import kg.easy.shop.models.entities.Supplier;
import kg.easy.shop.models.entities.SupplierPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierPhoneRepository extends JpaRepository<SupplierPhone, Long> {

    List<SupplierPhone> findAllBySupplier(Supplier supplier);
}
