package com.pedronieto.serverless_url_shortener.service;

import com.pedronieto.serverless_url_shortener.dto.UrlShortenerRequest;
import com.pedronieto.serverless_url_shortener.dto.UrlShortenerResponse;
import com.pedronieto.serverless_url_shortener.model.UrlMapping;
import com.pedronieto.serverless_url_shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IUrlService implements UrlService {
    @Qualifier("urlRepository")
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
