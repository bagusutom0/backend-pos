package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.transaction.TransactionDTO;
import com.bagus.point_of_sales.controller.db.transaction.TransactionRequest;
import com.bagus.point_of_sales.model.product.ProductRepository;
import com.bagus.point_of_sales.model.transaction.Transaction;
import com.bagus.point_of_sales.model.transaction.TransactionProduct;
import com.bagus.point_of_sales.model.transaction.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
//    private final TransactionProductRepository transactionProductRepository;
//    private final PGWRepository pgwRepository;

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream()
                .map(TransactionDTO::new)
                .toList();
    }

    public TransactionDTO addTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        transaction.setCreatedAt(LocalDateTime.now().format(formatter));

        transaction.setTotalAmount(request.getTotalAmount());
        transaction.setTotalPay(request.getTotalPay());
        List<TransactionProduct> transactionProducts = request.getOrderProducts().stream()
                        .map(orderProduct -> TransactionProduct.builder()
                                .transaction(transaction)
                                .product(productRepository.findById(orderProduct.getProduct().getId()).orElseThrow(() -> new EntityNotFoundException("Product not found")))
                                .quantity(orderProduct.getQuantity())
                                .subtotal(orderProduct.getSubtotal())
                                .build())
                        .toList();
        transaction.setTransactionProducts(transactionProducts);
        Transaction savedTransaction = transactionRepository.save(transaction);

        System.out.println(savedTransaction);

        return new TransactionDTO(savedTransaction);
    }

//    public TransactionDTO updatePaidTransaction(PaymentCustomerRequest request) {
//        PGW pgw = pgwRepository.findByMethod(PaymentMethod.valueOf(request.getPaymentMethod()))
//                .orElseThrow(() -> new EntityNotFoundException("Payment Gateway not found"));
//
//        if (pgw.getToken().equals(request.getToken())) {
//            Optional<Transaction> transactionOptional = transactionRepository.findByVaNumber(request.getVaNumber());
//            if (transactionOptional.isPresent()) {
//                Transaction transaction = transactionOptional.get();
//                transaction.setIsPaid(request.getIsPaid());
//                transaction.setPaymentDate(request.getPaymentDate());
//                Transaction savedTransaction = transactionRepository.save(transaction);
//
//                return new TransactionDTO(savedTransaction);
//            } else {
//                throw new EntityNotFoundException("Transaction not found");
//            }
//        } else {
//            throw new IllegalArgumentException("Invalid token");
//        }
//    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
