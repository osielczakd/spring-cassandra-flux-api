package nl.zwennesm.repository;

import nl.zwennesm.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository  {
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Mono<Product> findOne(String sku);
    Mono<Boolean> delete(String sku);
    Flux<Product> findByState(String state);
    Flux<Product> getAll();
}
