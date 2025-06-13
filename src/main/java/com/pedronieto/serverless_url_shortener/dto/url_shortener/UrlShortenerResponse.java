package com.pedronieto.serverless_url_shortener.dto.url_shortener;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlShortenerResponse {
    private String shortUrl;
}
