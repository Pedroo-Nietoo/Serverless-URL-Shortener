package com.pedronieto.serverless_url_shortener.repository.persistence;

import com.pedronieto.serverless_url_shortener.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserPersistenceRepository extends JpaRepository<User, UUID> {
}
