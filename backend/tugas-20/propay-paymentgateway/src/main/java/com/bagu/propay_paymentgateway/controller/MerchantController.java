package com.bagu.propay_paymentgateway.controller;

import com.bagu.propay_paymentgateway.entity.Merchant;
import com.bagu.propay_paymentgateway.entity.Transaction;
import com.bagu.propay_paymentgateway.entity.TransactionRepository;
import com.bagu.propay_paymentgateway.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/merchant")
//@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService service;

    public MerchantController(MerchantService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Merchant> registerMerchant(@RequestBody String merchantName) {
        return ResponseEntity.ok(service.registerMerchant(merchantName));
    }

    @PostMapping("/payment")
    public void paymentCustomer(@RequestBody PaymentCustomerRequest request) {
        service.paymentCustomer(request);
    }
}
