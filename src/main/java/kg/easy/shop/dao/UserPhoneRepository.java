package kg.easy.shop.dao;

import kg.easy.shop.models.entities.User;
import kg.easy.shop.models.entities.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {

    List<UserPhone> findAllByUser(User user);
}
