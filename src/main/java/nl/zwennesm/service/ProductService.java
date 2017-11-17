package nl.zwennesm.service;

import nl.zwennesm.model.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> find(String sku);
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
}
