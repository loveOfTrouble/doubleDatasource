package com.sinosoft.doubledatasource.config;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {


    private final MongoTemplate mongoTemplate;


    public MongoDbConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public GridFSBucket getGridFSBucket() {
        return GridFSBuckets.create(mongoTemplate.getDb());
    }
}
