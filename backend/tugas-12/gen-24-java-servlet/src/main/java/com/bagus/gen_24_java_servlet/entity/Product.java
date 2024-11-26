package com.bagus.gen_24_java_servlet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String nama;
    private String kategori;
    private Double harga;
    private Long stok;
}
