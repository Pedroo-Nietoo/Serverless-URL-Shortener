package com.pedronieto.serverless_url_shortener.domain;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class UrlMapping {

    private String id;
    private String shortUrl;
    private String originalUrl;
    private Instant createdAt;

    @DynamoDbPartitionKey
    public String getShortUrl() {
        return shortUrl;
    }
}