package com.pedronieto.serverless_url_shortener.controller;

import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerRequest;
import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerResponse;
import com.pedronieto.serverless_url_shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public ResponseEntity<UrlShortenerResponse> shorten(@RequestBody UrlShortenerRequest request) {
        return ResponseEntity.ok(urlService.shortenUrl(request));
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> resolve(@PathVariable String code) throws IOException {
        String original = urlService.resolveUrl(code);
        if (original == null) {
            ClassPathResource resource = new ClassPathResource("static/404.html");
            String body = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.status(404)
                    .header("Content-Type", "text/html")
                    .body(body);
        }
        return ResponseEntity.status(302).header("Location", original).build();
    }
}
