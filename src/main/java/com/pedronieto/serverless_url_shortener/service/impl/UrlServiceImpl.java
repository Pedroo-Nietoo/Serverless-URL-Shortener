package com.pedronieto.serverless_url_shortener.service.impl;

import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerRequest;
import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerResponse;
import com.pedronieto.serverless_url_shortener.domain.UrlMapping;
import com.pedronieto.serverless_url_shortener.repository.UrlRepository;
import com.pedronieto.serverless_url_shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    @Qualifier("dynamoDbUrlRepository")
    private final UrlRepository repository;

    @Override
    public UrlShortenerResponse shortenUrl(UrlShortenerRequest request) {
        String id = UUID.randomUUID().toString();
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        repository.save(new UrlMapping(id, shortCode, request.getOriginalUrl(), Instant.now()));
        return new UrlShortenerResponse("https://sho.rt/" + shortCode);
    }

    @Override
    public String resolveUrl(String shortCode) {
        UrlMapping mapping = repository.findByShortUrl(shortCode);
        return mapping != null ? mapping.getOriginalUrl() : null;
    }
}
