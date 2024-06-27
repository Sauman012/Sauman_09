package ru.alex.PP_3_1_2_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.PP_3_1_2_spring_boot.model.User;

public interface UserRepository extends JpaRepository <User,Long> {
}
