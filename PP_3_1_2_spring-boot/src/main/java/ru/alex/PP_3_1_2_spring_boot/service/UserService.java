package ru.alex.PP_3_1_2_spring_boot.service;

import ru.alex.PP_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

    public User save(User user);

    public void deleteById (Long id);
}
