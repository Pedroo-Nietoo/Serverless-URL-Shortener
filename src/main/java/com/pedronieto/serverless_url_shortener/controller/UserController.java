package com.pedronieto.serverless_url_shortener.controller;

import com.pedronieto.serverless_url_shortener.domain.User;
import com.pedronieto.serverless_url_shortener.dto.user.UserRequestDTO;
import com.pedronieto.serverless_url_shortener.dto.user.UserResponseDTO;
import com.pedronieto.serverless_url_shortener.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password()) // normalmente você aplicaria hashing
                .build();

        User created = userService.create(user);

        return ResponseEntity.ok(new UserResponseDTO(
                created.getId(),
                created.getUsername(),
                created.getEmail()
        ));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> list(Pageable pageable) {
        return ResponseEntity.ok(
                userService.getAll(pageable)
                        .map(u -> new UserResponseDTO(u.getId(), u.getUsername(), u.getEmail()))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> get(@PathVariable UUID id) {
        return userService.getById(id)
                .map(u -> new UserResponseDTO(u.getId(), u.getUsername(), u.getEmail()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid UserRequestDTO dto) {
        User updated = User.builder()
                .id(id)
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .build();

        User user = userService.update(updated);
        return ResponseEntity.ok(new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
