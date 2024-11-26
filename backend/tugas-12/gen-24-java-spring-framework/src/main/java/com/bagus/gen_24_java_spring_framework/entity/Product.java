package com.bagus.gen_24_java_spring_framework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Product {
    @Id
    private Long id;
    private String nama;
    private String kategori;
    private Double harga;
    private Long stok;
}
