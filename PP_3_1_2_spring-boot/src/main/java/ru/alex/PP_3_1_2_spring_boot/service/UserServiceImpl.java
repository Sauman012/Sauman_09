package ru.alex.PP_3_1_2_spring_boot.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.PP_3_1_2_spring_boot.model.User;
import ru.alex.PP_3_1_2_spring_boot.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return  userRepository.getOne(id);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }

}
