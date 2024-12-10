package com.bagu.propay_paymentgateway.controller;

import lombok.Data;

@Data
public class MerchantRequest {
    private String name;
    private String registerCallbackUri;
}
