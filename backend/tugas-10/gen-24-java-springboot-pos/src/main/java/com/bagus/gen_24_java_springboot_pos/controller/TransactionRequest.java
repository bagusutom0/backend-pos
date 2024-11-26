package com.bagus.gen_24_java_springboot_pos.controller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionRequest {
    private Long product_id;
    private int quantity;
    private int total_price;
    private String transaction_date;
}
