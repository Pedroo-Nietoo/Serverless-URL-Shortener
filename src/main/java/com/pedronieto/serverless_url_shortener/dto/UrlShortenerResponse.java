package com.pedronieto.serverless_url_shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlShortenerResponse {
    private String shortUrl;
}
