package com.bagus.gen_24_java_springboot_pos_producer_kafka.controller;

import com.bagus.gen_24_java_springboot_pos_producer_kafka.entity.Product;
import com.bagus.gen_24_java_springboot_pos_producer_kafka.entity.ProductRepository;
import com.bagus.gen_24_java_springboot_pos_producer_kafka.service.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository repository;
    private final KafkaProducerService service;

    public ProductController(ProductRepository repository, KafkaProducerService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/send-product")
    public String pushProductToKafka() {
        List<Product> products = repository.findAll();
        products.forEach(service::sendProduct);
        return products.size() + " products pushed to kafka";
    }

    @GetMapping("/test")
    public String testing() {
        return "testing";
    }
}
