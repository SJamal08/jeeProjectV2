package com.jeeproject.ecommerce.controller;

import com.jeeproject.ecommerce.model.User;
import com.jeeproject.ecommerce.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{userCode}")
    public ResponseEntity<User> getUserByUserCode (@PathVariable("userCode") String userCode) {
        User user = userService.findUserByUserCode(userCode);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userCode}")
    public ResponseEntity<?> deleteUser(@PathVariable("userCode") String userCode) {
        userService.deleteUser(userCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
