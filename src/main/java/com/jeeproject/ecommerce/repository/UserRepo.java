package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserByUserCode(String userCode);

    Optional<User> findUserByUserCode(String userCode);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
