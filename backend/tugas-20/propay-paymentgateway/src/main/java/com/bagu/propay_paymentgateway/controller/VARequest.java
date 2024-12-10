package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

@Data
public class VARequest {
    private String vaNumber;
    private Double amount;
    private String paymentCallbackUri;
}
