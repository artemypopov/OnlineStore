package com.example.OnlineStore.repository;

import com.example.OnlineStore.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    Optional<User> findById(Long id);
    List<User> findAll();
}
