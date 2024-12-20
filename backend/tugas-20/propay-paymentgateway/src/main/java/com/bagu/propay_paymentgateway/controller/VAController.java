package com.bagu.propay_paymentgateway.controller;

import com.bagu.propay_paymentgateway.entity.VA;
import com.bagu.propay_paymentgateway.service.VAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("propay/api/v1/va")
public class VAController {
    @Autowired
    private VAService service;

    @PostMapping("/add")
    public ResponseEntity<VA> insertVA(@RequestBody VARequest request) {
        return ResponseEntity.ok(service.insertVa(request));
    }

    @PostMapping("/payment")
    public ResponseEntity<VAResponse> paymentVA(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(service.processPayment(request));
    }
}
