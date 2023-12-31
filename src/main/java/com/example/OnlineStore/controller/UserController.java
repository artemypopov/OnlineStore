package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.user.User;
import com.example.OnlineStore.model.user.UserRequest;
import com.example.OnlineStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public String registerUser(@RequestBody UserRequest user) {
        try {
            userService.registerUser(user);
            return user.getUsername() + " is registered";
        } catch (Exception e) {
            return "registration failed. Because " + e.getLocalizedMessage();
        }
    }

    @GetMapping("/get/{username}")
    public User getByUsername (@PathVariable String username) {
            return userService.getByUsername(username);
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
