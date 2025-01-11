package com.bagus.point_of_sales.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;
}
