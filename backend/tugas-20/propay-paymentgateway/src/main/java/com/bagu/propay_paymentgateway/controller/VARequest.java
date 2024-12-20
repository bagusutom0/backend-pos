package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

@Data
public class VARequest {
    private String vaNumber;
    private Long amount;
    private String token;
    private String paymentCallbackUri;
}
