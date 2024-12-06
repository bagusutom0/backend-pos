package com.bagus.gen_24_java_springboot_pos_consumer_kafka.service;

import com.bagus.gen_24_java_springboot_pos_consumer_kafka.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private String product;

    @KafkaListener(topics = "product", groupId = "pos_consumer_group")
    public void consume(String product) {
        this.product = product;
        System.out.println("Received message: " + product);
    }

    public String getProduct() {
        return product;
    }
}
