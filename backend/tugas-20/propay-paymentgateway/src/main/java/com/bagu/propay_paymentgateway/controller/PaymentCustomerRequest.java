package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentCustomerRequest {
    private String vaNumber;
    private Boolean isPaid;
    private LocalDateTime paymentDate;
    private String token;
    private String paymentMethod;
}
