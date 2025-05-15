package com.pedronieto.serverless_url_shortener;

import com.pedronieto.serverless_url_shortener.config.DynamoDbProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(DynamoDbProperties.class)
public class ServerlessUrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerlessUrlShortenerApplication.class, args);
	}

}
