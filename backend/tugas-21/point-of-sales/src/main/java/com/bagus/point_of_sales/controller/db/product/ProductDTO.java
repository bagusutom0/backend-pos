package com.bagus.point_of_sales.controller.db.product;

import com.bagus.point_of_sales.model.product.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private int stock;
    private Long price;
    private String description;
    private Category category;
}
