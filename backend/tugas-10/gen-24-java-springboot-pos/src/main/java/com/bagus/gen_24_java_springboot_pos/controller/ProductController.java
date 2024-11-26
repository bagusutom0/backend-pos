package com.bagus.gen_24_java_springboot_pos.controller;

import com.bagus.gen_24_java_springboot_pos.entity.product.Product;
import com.bagus.gen_24_java_springboot_pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(service.createProduct(
                request.getCategory_id(),
                request.getName(),
                request.getStock(),
                request.getPrice()
        ));
    }

    @GetMapping("/native")
    public ResponseEntity<List<Product>> getAllProductNative() {
        return ResponseEntity.ok(service.getAllProductNative());
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<Product>> getAllProductJpql() {
        return ResponseEntity.ok(service.getAllProductJpql());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> getFilteredProduct(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int stock
    ) {
        return ResponseEntity.ok(service.filterProduct(name, stock));
    }
}
