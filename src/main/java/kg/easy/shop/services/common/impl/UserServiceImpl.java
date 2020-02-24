package kg.easy.shop.services.common.impl;

import kg.easy.shop.dao.UserRepository;
import kg.easy.shop.models.entities.User;
import kg.easy.shop.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        User user =  userRepository.findById(id).orElse(null);

        if (user == null) {
            throw  new RuntimeException("Пользователь не существует!");
        }

        return user;
    }
}
