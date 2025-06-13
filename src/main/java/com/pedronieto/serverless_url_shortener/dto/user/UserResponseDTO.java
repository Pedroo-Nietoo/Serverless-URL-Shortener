package com.pedronieto.serverless_url_shortener.dto.user;

import java.util.UUID;

public record UserResponseDTO(UUID id, String username, String email) {
}
