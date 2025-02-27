package org.apereo.cas.monitor;

import lombok.val;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.stream.Collectors;

/**
 * This is {@link MongoDbHealthIndicator} where it attempts to collect statistics
 * on all mongodb instances configured inside CAS.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
public class MongoDbHealthIndicator extends AbstractCacheHealthIndicator {
    private final MongoTemplate mongoTemplate;

    public MongoDbHealthIndicator(final MongoTemplate mongoTemplate,
                                  final long evictionThreshold,
                                  final long threshold) {
        super(evictionThreshold, threshold);
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected CacheStatistics[] getStatistics() {
        val list = mongoTemplate.getCollectionNames()
            .stream()
            .map(c -> {
                val db = mongoTemplate.getMongoDatabaseFactory().getMongoDatabase();
                val stats = db.runCommand(new Document("collStats", c));
                return new MongoDbCacheStatistics(stats, c);
            })
            .collect(Collectors.toList());

        return list.toArray(CacheStatistics[]::new);
    }

    @Override
    protected String getName() {
        val dbName = mongoTemplate.getMongoDatabaseFactory().getMongoDatabase().getName();
        return super.getName() + '-' + dbName;
    }
}
