package com.bagus.point_of_sales.controller.db.payment;

import com.bagus.point_of_sales.model.payment.PGW;
import com.bagus.point_of_sales.service.db.PGWService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pgw")
@RequiredArgsConstructor
public class PGWController {
    private final PGWService service;

    @PostMapping("/add")
    public ResponseEntity<PGW> addPgw(@RequestBody PgwRequest request) {
        return ResponseEntity.ok(service.insertPgw(request));
    }
}
