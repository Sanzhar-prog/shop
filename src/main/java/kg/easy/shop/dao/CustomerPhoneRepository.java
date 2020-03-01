package kg.easy.shop.dao;

import kg.easy.shop.models.entities.Customer;
import kg.easy.shop.models.entities.CustomerPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, Long> {

    List<CustomerPhone> findAllByCustomer(Customer customer);
}
