package kg.easy.shop.dao;

import kg.easy.shop.models.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepo extends JpaRepository<UserStatus,Long> {
}
