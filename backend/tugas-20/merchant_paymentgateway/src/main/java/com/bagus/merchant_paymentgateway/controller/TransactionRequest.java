package com.bagus.merchant_paymentgateway.controller;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long userId;
    private String description;
    private Double amount;
}
