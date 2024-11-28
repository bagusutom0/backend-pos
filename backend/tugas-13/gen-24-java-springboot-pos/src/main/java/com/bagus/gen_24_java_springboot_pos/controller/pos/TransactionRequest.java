package com.bagus.gen_24_java_springboot_pos.controller.pos;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long product_id;
    private int quantity;
    private int total_price;
    private String transaction_date;
}
