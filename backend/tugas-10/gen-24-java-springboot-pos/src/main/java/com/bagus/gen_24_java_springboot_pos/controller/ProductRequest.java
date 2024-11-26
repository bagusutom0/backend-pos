package com.bagus.gen_24_java_springboot_pos.controller;

import lombok.Data;

@Data
public class ProductRequest {
    private Long category_id;
    private String name;
    private int stock;
    private int price;
}
