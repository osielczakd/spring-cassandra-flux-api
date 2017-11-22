package nl.zwennesm.repository;

import nl.zwennesm.model.Recommendation;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CassandraProductRepository implements ProductRepository {

    private final ReactiveCassandraOperations cassandraTemplate;

    public CassandraProductRepository(ReactiveCassandraOperations cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public Mono<Recommendation> save(Recommendation product) {
        return this.cassandraTemplate.insert(product);
    }

    @Override
    public Mono<Recommendation> update(Recommendation product) {
        return cassandraTemplate.update(product);
    }

    @Override
    public Mono<Recommendation> findOne(String sku) {
        return this.cassandraTemplate.selectOneById(sku, Recommendation.class);
    }

    @Override
    public Mono<Boolean> delete(String sku) {
        return null;
    }

    @Override
    public Flux<Recommendation> findByState(String state) {
        return null;
    }

    @Override
    public Flux<Recommendation> getAll() {
        return this.cassandraTemplate.select("select * from sample.recommend", Recommendation.class);
    }
}
