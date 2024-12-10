package com.bagus.merchant_paymentgateway.controller;

import lombok.Data;

@Data
public class VaRequest {
    private String vaNumber;
    private Double amount;
    private String paymentCallbackUri;
}
