package com.pedronieto.serverless_url_shortener.dto;

import lombok.Data;

@Data
public class UrlShortenerRequest {
    private String originalUrl;
}
