package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

@Data
public class PaymentRequest {
    private String vaNumber;
    private String paymentMethod;
}
