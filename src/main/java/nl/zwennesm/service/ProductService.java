package nl.zwennesm.service;

import nl.zwennesm.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> findOne(String sku);
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Flux<Product> getAll();
}
