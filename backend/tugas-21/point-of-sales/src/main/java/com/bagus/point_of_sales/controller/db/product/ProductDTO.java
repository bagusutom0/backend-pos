package com.bagus.point_of_sales.controller.db.product;

import com.bagus.point_of_sales.model.product.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private List<String> image;
    private String name;
    private Long price;
    private List<String> review;
    private String description;
    private List<String> colour;
    private List<String> size;
    private List<String> length;
    private int stock;
    private Category category;
}
