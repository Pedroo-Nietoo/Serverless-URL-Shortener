package com.pedronieto.serverless_url_shortener.repository.implementation;

import com.pedronieto.serverless_url_shortener.model.UrlMapping;
import com.pedronieto.serverless_url_shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@RequiredArgsConstructor
public class DynamoDbUrlRepository implements UrlRepository {
    private final DynamoDbEnhancedClient enhancedClient;

    @Value("${dynamodb.tableName}")
    private String tableName;

    private DynamoDbTable<UrlMapping> getTable() {
        return enhancedClient.table(tableName, TableSchema.fromBean(UrlMapping.class));
    }

    @Override
    public void save(UrlMapping mapping) {
        getTable().putItem(mapping);
    }

    @Override
    public UrlMapping findByShortUrl(String shortCode) {
        return getTable().getItem(r -> r.key(k -> k.partitionValue(shortCode)));
    }
}