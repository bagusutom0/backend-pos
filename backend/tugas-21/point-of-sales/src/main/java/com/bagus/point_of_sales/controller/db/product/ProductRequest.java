package com.bagus.point_of_sales.controller.db.product;

import lombok.Data;

import java.util.List;

@Data
public class  ProductRequest {
    private String name;
    private String image;
    private Long price;
    private Long categoryId;
}
