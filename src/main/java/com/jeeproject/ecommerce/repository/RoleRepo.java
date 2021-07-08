package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.ERole;
import com.jeeproject.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
