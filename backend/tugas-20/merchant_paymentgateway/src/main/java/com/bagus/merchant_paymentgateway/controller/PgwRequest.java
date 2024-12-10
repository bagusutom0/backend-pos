package com.bagus.merchant_paymentgateway.controller;

import lombok.Data;

@Data
public class PgwRequest {
    private String pgwName;
    private String merchantUcode;
}
