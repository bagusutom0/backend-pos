package com.bagu.propay_paymentgateway.controller;

import com.bagu.propay_paymentgateway.service.VAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/va")
public class VAController {
    @Autowired
    private VAService service;

    @PostMapping("/insert")
    public ResponseEntity<String> insertVA(@RequestBody VARequest request) {
        return ResponseEntity.ok(service.insertVa(request));
    }

    @PostMapping("/payment")
    public ResponseEntity<String> paymentVA(@RequestBody String vaNumber) {
        if (service.isPaymentSuccess(vaNumber)) {
            return ResponseEntity.ok("Payment Successfull");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Virtual Account Number not found");
        }
    }
}
