package com.example.OnlineStore.service;

import com.example.OnlineStore.model.user.Role;
import com.example.OnlineStore.model.user.User;
import com.example.OnlineStore.model.user.UserRequest;
import com.example.OnlineStore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(),
                myUser.getPassword(), mapRolesToAthorities(myUser.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    public void registerUser(UserRequest userRq) throws Exception {
        boolean userExists = userRepository.existsByUsername(userRq.getUsername());
        if (userExists) {
            throw new Exception("user exist");
        }
        if (userRq.getUsername() == null) {
            throw new Exception("username must not be null");
        }
        User user = new User();
        user.setUsername(userRq.getUsername());
        user.setFirstName(userRq.getFirstName());
        user.setLastName(userRq.getLastName());
        user.setCity(userRq.getCity());
        user.setPassword(userRq.getPassword());
        user.setRoles(Collections.singleton(Role.USER));
        user.setIsActive(true);
        userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getCurrentUser() {
        return userRepository.findByUsername(getAuthenticationInfo().getName());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public Authentication getAuthenticationInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
