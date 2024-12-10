package com.bagus.merchant_paymentgateway.controller;

import com.bagus.merchant_paymentgateway.entity.PGW;
import com.bagus.merchant_paymentgateway.service.PGWService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tokopedia/api/v1/pgw")
@RequiredArgsConstructor
public class PGWController {
    private final PGWService service;

    @PostMapping("/add")
    public ResponseEntity<PGW> addPgw(@RequestBody PgwRequest request) {
        return ResponseEntity.ok(service.insertPgw(request));
    }
}
