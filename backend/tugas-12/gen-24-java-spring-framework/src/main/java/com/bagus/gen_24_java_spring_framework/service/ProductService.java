package com.bagus.gen_24_java_spring_framework.service;

import com.bagus.gen_24_java_spring_framework.entity.Product;
import com.bagus.gen_24_java_spring_framework.entity.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository repository;

    private List<Product> products = new ArrayList<>();

    public void saveProducts(Product product) {
        repository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
