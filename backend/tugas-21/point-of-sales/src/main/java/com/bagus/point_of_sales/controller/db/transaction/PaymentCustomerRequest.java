package com.bagus.point_of_sales.controller.db.transaction;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentCustomerRequest {
    private String vaNumber;
    private Boolean isPaid;
    private String token;
    private String paymentMethod;
    private LocalDateTime paymentDate;
}
