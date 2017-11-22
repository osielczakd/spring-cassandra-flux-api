package nl.zwennesm.repository;

import nl.zwennesm.model.Recommendation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository  {
    Mono<Recommendation> save(Recommendation product);
    Mono<Recommendation> update(Recommendation product);
    Mono<Recommendation> findOne(String sku);
    Mono<Boolean> delete(String sku);
    Flux<Recommendation> findByState(String state);
    Flux<Recommendation> getAll();
}
