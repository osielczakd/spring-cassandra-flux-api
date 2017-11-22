package nl.zwennesm.service;

import nl.zwennesm.model.Recommendation;
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
    public Mono<Recommendation> find(String sku) {
        return productRepository.findOne(sku);
    }

    @Override
    public Mono<Recommendation> save(Recommendation product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Recommendation> update(Recommendation product) {
        return productRepository.findOne(product.getSku())
                .filter(Objects::nonNull)
                .flatMap(f -> productRepository.update(product))
                .doOnSuccess(s -> log.info("success"))
                .doOnError(i -> new RetrievalException("Could not handle Mono type"));
    }

    @Override
    public Flux<Recommendation> getAll() {
        return productRepository.getAll();
    }

}
