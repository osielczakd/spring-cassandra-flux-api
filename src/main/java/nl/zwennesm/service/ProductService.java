package nl.zwennesm.service;

import nl.zwennesm.model.Recommendation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Recommendation> find(String sku);
    Mono<Recommendation> save(Recommendation product);
    Mono<Recommendation> update(Recommendation product);
    Flux<Recommendation> getAll();
}
