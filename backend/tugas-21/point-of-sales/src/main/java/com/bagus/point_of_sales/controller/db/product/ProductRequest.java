package com.bagus.point_of_sales.controller.db.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private int stock;
    private Long price;
    private String description;
    private Long categoryId;
}
