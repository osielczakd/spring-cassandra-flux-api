package nl.zwennesm.controller;

import nl.zwennesm.model.Product;
import nl.zwennesm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommend/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/add")
    public Mono<Product> put(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @GetMapping(path = "/{sku}")
    public Mono<Product> get(@PathVariable("sku") String sku) {
        return this.productService.findOne(sku);
    }

    @PostMapping(path = "/{sku}")
    public Mono<Product> update(@RequestBody Product product) {
        return this.productService.update(product);
    }

    @GetMapping(path = "/all")
    public Flux<Product> all() { return this.productService.getAll(); }
}
