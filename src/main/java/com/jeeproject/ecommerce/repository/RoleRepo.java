package com.jeeproject.ecommerce.repository;


import com.jeeproject.ecommerce.model.Role;
import com.jeeproject.ecommerce.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
