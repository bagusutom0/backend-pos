package com.bagus.point_of_sales.controller.db.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    private List<String> image;
    private String name;
    private Long price;
    private List<String> review;
    private String description;
    private List<String> colour;
    private List<String> size;
    private List<String> length;
    private int stock;
    private Long categoryId;
}
