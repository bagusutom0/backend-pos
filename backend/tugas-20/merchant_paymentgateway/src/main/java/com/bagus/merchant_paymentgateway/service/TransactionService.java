package com.bagus.merchant_paymentgateway.service;

import com.bagus.merchant_paymentgateway.controller.PaymentCustomerRequest;
import com.bagus.merchant_paymentgateway.controller.TransactionRequest;
import com.bagus.merchant_paymentgateway.controller.VaRequest;
import com.bagus.merchant_paymentgateway.entity.PGW;
import com.bagus.merchant_paymentgateway.entity.PGWRepository;
import com.bagus.merchant_paymentgateway.entity.Transaction;
import com.bagus.merchant_paymentgateway.entity.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final PGWRepository pgwRepository;

    public Transaction addTransaction(TransactionRequest request) {
        Optional<PGW> pgw = pgwRepository.findByPgwName("ProPay");
        if (pgw.isPresent()) {
            String unicode = pgw.get().getMerchantUcode();
            String vaNumber = unicode + request.getUserId();

            Transaction transaction = Transaction.builder()
                    .userId(request.getUserId())
                    .description(request.getDescription())
                    .amount(request.getAmount())
                    .paid(false)
                    .vaNumber(vaNumber)
                    .paymentDate(null)
                    .createdAt(LocalDateTime.now())
                    .build();

            // insert va
            String url = "http://localhost:8081/propay/api/v1/va/add";
            WebClient.Builder webClientBuilder = WebClient.builder();
            VaRequest vaRequest = new VaRequest();
            vaRequest.setVaNumber(vaNumber);
            vaRequest.setAmount(request.getAmount());
            vaRequest.setPaymentCallbackUri("http://localhost:8082/tokopedia/api/v1/transaction/payment");

            webClientBuilder.build()
                    .post()
                    .uri(url)
                    .bodyValue(vaRequest)
                    .retrieve()
                    .toBodilessEntity()
                    .doOnSuccess(response -> System.out.println("Insert Virtual Account successfull"))
                    .doOnError(error -> System.err.println("Failed to insert Virtual Account: " + error.getMessage()))
                    .subscribe();

            return transactionRepository.save(transaction);
        } else {
            throw new EntityNotFoundException("Customer not found");
        }
    }

    public Transaction updatePaidTransaction(PaymentCustomerRequest request) {
        Optional<Transaction> transactionOptional = transactionRepository.findByVaNumber(request.getVaNumber());
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            transaction.setPaid(request.getPaid());
            transaction.setPaymentDate(request.getPaymentDate());
            return transactionRepository.save(transaction);
        } else {
            throw new EntityNotFoundException("Transaction not found");
        }
    }
}
