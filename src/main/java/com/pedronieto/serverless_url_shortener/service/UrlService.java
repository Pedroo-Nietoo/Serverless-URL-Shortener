package com.pedronieto.serverless_url_shortener.service;

import com.pedronieto.serverless_url_shortener.dto.UrlShortenerRequest;
import com.pedronieto.serverless_url_shortener.dto.UrlShortenerResponse;

public interface UrlService {
    UrlShortenerResponse shortenUrl(UrlShortenerRequest request);
    String resolveUrl(String shortCode);
}