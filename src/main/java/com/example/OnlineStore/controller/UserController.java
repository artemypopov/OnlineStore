package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.user.User;
import com.example.OnlineStore.model.user.UserRequestDTO;
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
    public String registerUser(@RequestBody UserRequestDTO user) {
        try {
            userService.registerUser(user);
            return user.getUsername() + " is registered";
        } catch (Exception e) {
            return "registration failed. Because " + e.getLocalizedMessage();
        }
    }

    @GetMapping("/get/{username}")
    public User getUser(@PathVariable String username) {
            return userService.getUser(username);
    }

    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
