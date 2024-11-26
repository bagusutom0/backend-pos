package com.bagus.gen_24_java_springboot_pos.controller;

import com.bagus.gen_24_java_springboot_pos.entity.product.Product;
import com.bagus.gen_24_java_springboot_pos.entity.transaction.Transaction;
import com.bagus.gen_24_java_springboot_pos.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");
        LocalDateTime parsedTime = LocalDateTime.parse(request.getTransaction_date(), formatter);

        return ResponseEntity.ok(service.createTransaction(
                request.getProduct_id(),
                request.getQuantity(),
                request.getTotal_price(),
                parsedTime));
    }

    @GetMapping("/native")
    public ResponseEntity<List<Transaction>> getAllProductNative() {
        return ResponseEntity.ok(service.getAllTransactionNative());
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<Transaction>> getAllProductJpql() {
        return ResponseEntity.ok(service.getAllTransactionJpql());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Transaction>> getFilteredProduct(
            @RequestParam(required = false) int quantity
    ) {
        return ResponseEntity.ok(service.filterTransaction(quantity));
    }
}
