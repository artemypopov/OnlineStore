package com.example.OnlineStore.model.user;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class UserRequestDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String password;
}
