package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentCustomerRequest {
    private String vaNumber;
    private Boolean paid;
    private LocalDateTime paymentDate;
}
