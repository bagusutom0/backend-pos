package com.bagus.gen_24_java_springboot_pos_producer_kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
    @Id
    private Long id;
    private String name;
    private int price;

    public Product() {}

    public Product(String name, Long id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
