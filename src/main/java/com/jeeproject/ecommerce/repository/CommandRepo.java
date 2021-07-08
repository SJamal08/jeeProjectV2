package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandRepo extends JpaRepository<Command,Long>{

    void deleteCommandByCommandCode(String commandCode);

    Optional<Command> findCommandByCommandCode(String commandCode);
}
