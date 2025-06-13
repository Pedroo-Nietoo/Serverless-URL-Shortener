package com.pedronieto.serverless_url_shortener.config.dynamodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "dynamodb")
public class DynamoDbProperties {
    private String tableName;
    private String region;
}