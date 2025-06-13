package com.pedronieto.serverless_url_shortener.repository.impl;

import com.pedronieto.serverless_url_shortener.domain.User;
import com.pedronieto.serverless_url_shortener.repository.UserRepository;
import com.pedronieto.serverless_url_shortener.repository.persistence.UserPersistenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserPersistenceRepository userPersistenceRepository;

    @Override
    public User create(User user) {
        return userPersistenceRepository.save(user);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userPersistenceRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getById(UUID id) {
        return userPersistenceRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userPersistenceRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        userPersistenceRepository.deleteById(id);
    }
}