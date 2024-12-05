package com.bagus.gen_24_java_springboot_pos_producer_kafka.service;

import com.bagus.gen_24_java_springboot_pos_producer_kafka.entity.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private String topicName = "product";

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProduct(Product product) {
        kafkaTemplate.send(topicName, product);
    }
}
