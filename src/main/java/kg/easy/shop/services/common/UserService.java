package kg.easy.shop.services.common;

import kg.easy.shop.models.entities.User;

public interface UserService {

    User saveUser(User user);



    User findUserById(Long id);
}