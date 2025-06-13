package com.pedronieto.serverless_url_shortener.service;

import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerRequest;
import com.pedronieto.serverless_url_shortener.dto.url_shortener.UrlShortenerResponse;

public interface UrlService {
    UrlShortenerResponse shortenUrl(UrlShortenerRequest request);
    String resolveUrl(String shortCode);
}