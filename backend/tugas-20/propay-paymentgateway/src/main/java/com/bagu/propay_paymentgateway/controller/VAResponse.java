package com.bagu.propay_paymentgateway.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VAResponse {
    private String vaNumber;
    private Double amount;
}
