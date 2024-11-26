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
        repository.save()
    }
}
