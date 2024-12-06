package com.bagus.gen_24_java_springboot_pos_consumer_kafka.controller;

import com.bagus.gen_24_java_springboot_pos_consumer_kafka.model.Product;
import com.bagus.gen_24_java_springboot_pos_consumer_kafka.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final KafkaConsumerService service;

    public ProductController(KafkaConsumerService service) {
        this.service = service;
    }

    @GetMapping("/consume")
    public String consumeProduct() {
        return service.getProduct();
    }
}
