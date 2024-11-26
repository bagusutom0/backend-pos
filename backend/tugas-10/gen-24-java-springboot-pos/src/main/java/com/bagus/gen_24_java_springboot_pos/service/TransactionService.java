package com.bagus.gen_24_java_springboot_pos.service;

import com.bagus.gen_24_java_springboot_pos.entity.product.Product;
import com.bagus.gen_24_java_springboot_pos.entity.product.ProductRepository;
import com.bagus.gen_24_java_springboot_pos.entity.transaction.Transaction;
import com.bagus.gen_24_java_springboot_pos.entity.transaction.TransactionRepository;
import com.bagus.gen_24_java_springboot_pos.entity.transaction.TransactionSpecifications;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    public List<Transaction> filterTransaction(int quantity) {
        Specification<Transaction> spec = Specification
                .where(TransactionSpecifications.hasQuantityMoreThanOrEqual(quantity));
        return transactionRepository.findAll(spec);
    }

    public List<Transaction> getAllTransactionNative() {
        return transactionRepository.findAllTransactionNative();
    }

    public List<Transaction> getAllTransactionJpql() {
        return transactionRepository.findAllTransactionJpql();
    }

    public Transaction createTransaction(
            Long product_id,
            int quantity,
            int total_price,
            LocalDateTime transaction_date
    ) {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Transaction transaction = new Transaction();
        transaction.setProduct(product);
        transaction.setQuantity(quantity);
        transaction.setTotal_price(total_price);
        transaction.setTransaction_date(transaction_date);

        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(
            Long transaction_id,
            Long product_id,
            int quantity,
            int total_price,
            LocalDateTime transaction_date
    ) {
        return transactionRepository.findById(transaction_id)
                .map(transaction -> {
                    Product product = productRepository.findById(product_id)
                            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
                    transaction.setTransaction_date(transaction_date);
                    transaction.setProduct(product);
                    transaction.setQuantity(quantity);
                    transaction.setTotal_price(total_price);
                    return transactionRepository.save(transaction);
                })
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
