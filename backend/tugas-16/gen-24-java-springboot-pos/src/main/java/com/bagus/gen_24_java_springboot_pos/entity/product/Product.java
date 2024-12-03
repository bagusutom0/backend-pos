package com.bagus.gen_24_java_springboot_pos.entity.product;

import com.bagus.gen_24_java_springboot_pos.entity.category.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "product_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq"
    )
    private Long product_id;

    private String name;
    private int price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
