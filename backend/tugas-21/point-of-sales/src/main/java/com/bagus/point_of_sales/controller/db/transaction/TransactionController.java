package com.bagus.point_of_sales.controller.db.transaction;

import com.bagus.point_of_sales.service.db.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(service.getAllTransactions());
    }

    @PostMapping("/add")
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(service.addTransaction(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);

        Map<String, String> response = new HashMap<>();
        String message = "Transaction with id " + id + " has been deleted successfully";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/payment")
//    public ResponseEntity<TransactionDTO> paymentTransaction(@RequestBody PaymentCustomerRequest request) {
//        return ResponseEntity.ok(service.updatePaidTransaction(request));
//    }
}
