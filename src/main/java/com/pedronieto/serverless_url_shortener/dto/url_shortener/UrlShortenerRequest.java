package com.pedronieto.serverless_url_shortener.dto.url_shortener;

import lombok.Data;

@Data
public class UrlShortenerRequest {
    private String originalUrl;
}
