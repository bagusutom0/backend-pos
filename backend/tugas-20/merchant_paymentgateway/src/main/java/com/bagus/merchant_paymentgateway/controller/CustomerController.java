package com.bagus.merchant_paymentgateway.controller;

import com.bagus.merchant_paymentgateway.entity.Customer;
import com.bagus.merchant_paymentgateway.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tokopedia/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.insertCustomer(request));
    }
}
