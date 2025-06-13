package com.pedronieto.serverless_url_shortener.service;

import com.pedronieto.serverless_url_shortener.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User create(User user);
    Page<User> getAll(Pageable pageable);
    Optional<User> getById(UUID id);
    User update(User user);
    void delete(UUID id);
}
