package com.pedronieto.serverless_url_shortener.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank @Size(min = 3, max = 30)
        String username,
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 6)
        String password
) {
}
