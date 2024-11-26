package com.bagus.gen_24_java_spring_framework.service;

import com.bagus.gen_24_java_spring_framework.entity.Product;
import com.bagus.gen_24_java_spring_framework.entity.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    private List<Product> products = new ArrayList<>();

    public void saveProducts() {
        repository.save(new Product(1L, "Tahu", "Makanan", 5000.0, 50L));
        repository.save(new Product(2L, "Tempe", "Makanan", 3000.0, 55L));
        repository.save(new Product(3L, "Aqua", "Minuman", 2800.0, 100L));
        repository.save(new Product(4L, "Golda Coffee", "Minuman", 3000.0, 80L));
        repository.save(new Product(5L, "Bodrex", "Obat", 10000.0, 20L));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
