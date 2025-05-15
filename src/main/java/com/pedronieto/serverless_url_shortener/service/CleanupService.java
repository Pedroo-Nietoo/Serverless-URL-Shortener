package com.pedronieto.serverless_url_shortener.service;

import com.pedronieto.serverless_url_shortener.model.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class CleanupService {

    private final DynamoDbEnhancedClient enhancedClient;

    @Value("${dynamodb.tableName}")
    private String tableName;

    private static final int EXPIRATION_DAYS = 7;

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteExpiredTokens() {
        DynamoDbTable<UrlMapping> table = enhancedClient.table(tableName, TableSchema.fromBean(UrlMapping.class));

        Instant sevenDaysAgo = Instant.now().minus(EXPIRATION_DAYS, ChronoUnit.DAYS);

        Iterator<UrlMapping> items = table.scan(ScanEnhancedRequest.builder().build()).items().iterator();

        while (items.hasNext()) {
            UrlMapping mapping = items.next();
            if (mapping.getCreatedAt() != null && mapping.getCreatedAt().isBefore(sevenDaysAgo)) {
                table.deleteItem(mapping);
                System.out.println("Deleted expired token with id: " + mapping.getId());
            }
        }
    }
}