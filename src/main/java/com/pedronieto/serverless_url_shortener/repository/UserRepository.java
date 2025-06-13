package com.pedronieto.serverless_url_shortener.repository;

import com.pedronieto.serverless_url_shortener.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Page<User> findAll(Pageable pageable);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    User update(User user);
    void delete(UUID id);
}