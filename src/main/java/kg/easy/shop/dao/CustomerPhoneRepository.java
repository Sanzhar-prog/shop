package kg.easy.shop.dao;

import kg.easy.shop.models.entities.Customer;
import kg.easy.shop.models.entities.CustomerPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, Long> {

    List<CustomerPhone> findAllByCustomer(Customer customer);
}
