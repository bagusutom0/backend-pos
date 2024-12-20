package com.bagus.point_of_sales.controller.db.payment;

import lombok.Data;

@Data
public class VaRequest {
    private String vaNumber;
    private Long amount;
    private String token;
    private String paymentCallbackUri;
}
