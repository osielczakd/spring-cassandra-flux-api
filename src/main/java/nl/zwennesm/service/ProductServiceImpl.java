package nl.zwennesm.service;

import nl.zwennesm.model.Product;
import nl.zwennesm.repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private static Logger log = Logger.getLogger(ProductServiceImpl.class.getName());
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> findOne(String sku) {
        return productRepository.findOne(sku);
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.findOne(product.getSku())
                .filter(Objects::nonNull)
                .flatMap(f -> productRepository.update(product))
                .doOnSuccess(s -> log.info("success"))
                .doOnError(i -> log.error(i.getMessage()));
    }

    @Override
    public Flux<Product> getAll() {
        return productRepository.getAll();
    }

}
