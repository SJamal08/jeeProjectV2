package com.jeeproject.ecommerce.services;

import com.jeeproject.ecommerce.Exception.UserNotFoundException;
import com.jeeproject.ecommerce.model.User;
import com.jeeproject.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserByUserCode(String userCode) {
        return userRepo.findUserByUserCode(userCode)
                .orElseThrow(() -> new UserNotFoundException("User by code " + userCode + " was not found"));
    }

    public void deleteUser(String userCode){
        userRepo.deleteUserByUserCode(userCode);
    }
}
