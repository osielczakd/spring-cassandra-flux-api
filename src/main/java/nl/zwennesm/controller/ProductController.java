package nl.zwennesm.controller;

import nl.zwennesm.model.Recommendation;
import nl.zwennesm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/recommend/add")
    public Mono<Recommendation> put(@RequestBody Recommendation product) {
        return this.productService.save(product);
    }

    @GetMapping(path = "/recommend/{sku}")
    public Mono<Recommendation> get(@PathVariable("sku") String sku) {
        return this.productService.find(sku);
    }

    @PostMapping(path = "/recommend/{sku}")
    public Mono<Recommendation> update(@RequestBody Recommendation product) {
        return this.productService.update(product);
    }

    @GetMapping(path = "/recommend/all")
    public Flux<Recommendation> all() { return this.productService.getAll(); }
}
