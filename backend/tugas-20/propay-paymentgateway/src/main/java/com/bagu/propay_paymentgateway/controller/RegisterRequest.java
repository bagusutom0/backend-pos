package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

@Data
public class RegisterRequest {
    private String pgwName;
    private String merchantUcode;
    private String token;
    private String method;
}
