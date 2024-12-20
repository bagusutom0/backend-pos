package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.transaction.PaymentCustomerRequest;
import com.bagus.point_of_sales.controller.db.transaction.TransactionDTO;
import com.bagus.point_of_sales.model.payment.PGW;
import com.bagus.point_of_sales.model.payment.PGWRepository;
import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import com.bagus.point_of_sales.model.transaction.Transaction;
import com.bagus.point_of_sales.model.transaction.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
//    private final TransactionProductRepository transactionProductRepository;
    private final PGWRepository pgwRepository;

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream()
                .map(TransactionDTO::new)
                .toList();
    }

    public TransactionDTO updatePaidTransaction(PaymentCustomerRequest request) {
        PGW pgw = pgwRepository.findByMethod(PaymentMethod.valueOf(request.getPaymentMethod()))
                .orElseThrow(() -> new EntityNotFoundException("Payment Gateway not found"));

        if (pgw.getToken().equals(request.getToken())) {
            Optional<Transaction> transactionOptional = transactionRepository.findByVaNumber(request.getVaNumber());
            if (transactionOptional.isPresent()) {
                Transaction transaction = transactionOptional.get();
                transaction.setIsPaid(request.getIsPaid());
                transaction.setPaymentDate(request.getPaymentDate());
                Transaction savedTransaction = transactionRepository.save(transaction);

                return new TransactionDTO(savedTransaction);
            } else {
                throw new EntityNotFoundException("Transaction not found");
            }
        } else {
            throw new IllegalArgumentException("Invalid token");
        }
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
