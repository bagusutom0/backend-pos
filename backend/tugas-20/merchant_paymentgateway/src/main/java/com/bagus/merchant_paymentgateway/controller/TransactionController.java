package com.bagus.merchant_paymentgateway.controller;

import com.bagus.merchant_paymentgateway.entity.Transaction;
import com.bagus.merchant_paymentgateway.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tokopedia/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(service.addTransaction(request));
    }

    @PostMapping("/payment")
    public ResponseEntity<Transaction> paymentTransaction(@RequestBody PaymentCustomerRequest request) {
        return ResponseEntity.ok(service.updatePaidTransaction(request));
    }
}
