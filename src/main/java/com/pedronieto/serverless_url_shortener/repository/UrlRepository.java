package com.pedronieto.serverless_url_shortener.repository;


import com.pedronieto.serverless_url_shortener.model.UrlMapping;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository {
    void save(UrlMapping mapping);
    UrlMapping findByShortUrl(String shortCode);
}