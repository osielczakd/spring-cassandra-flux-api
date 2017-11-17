package nl.zwennesm.repository;

import nl.zwennesm.model.Product;
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
    public Mono<Product> save(Product product) {
        return this.cassandraTemplate.insert(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return cassandraTemplate.update(product);
    }

    @Override
    public Mono<Product> findOne(String sku) {
        return this.cassandraTemplate.selectOneById(sku, Product.class);
    }

    @Override
    public Mono<Boolean> delete(String sku) {
        return null;
    }

    @Override
    public Flux<Product> findByState(String state) {
        return null;
    }
}
