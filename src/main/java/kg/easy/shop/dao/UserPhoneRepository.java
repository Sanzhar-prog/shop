package kg.easy.shop.dao;

import kg.easy.shop.models.entities.User;
import kg.easy.shop.models.entities.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {

    List<UserPhone> findAllByUser(User user);
}
