package com.example.OnlineStore.model.user;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class UserRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String password;
}
