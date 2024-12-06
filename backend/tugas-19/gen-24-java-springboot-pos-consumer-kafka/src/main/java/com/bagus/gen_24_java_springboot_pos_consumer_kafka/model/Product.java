package com.bagus.gen_24_java_springboot_pos_consumer_kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private int price;
}
