package com.bagus.gen_24_java_springboot_pos_consumer_kafka.service;

import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "product", groupId = "group_id")
    public void consume()
}
