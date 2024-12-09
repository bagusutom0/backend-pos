package com.bagu.propay_paymentgateway.service;

import com.bagu.propay_paymentgateway.controller.PaymentCustomerRequest;
import com.bagu.propay_paymentgateway.entity.Merchant;
import com.bagu.propay_paymentgateway.entity.MerchantRepository;
import com.bagu.propay_paymentgateway.entity.Transaction;
import com.bagu.propay_paymentgateway.entity.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@RequiredArgsConstructor
@Transactional
public class MerchantService {
    private final MerchantRepository merchantRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public MerchantService(MerchantRepository repository) {
        this.merchantRepository = repository;
    }

    public Merchant registerMerchant(String merchantName) {
        Merchant merchant = new Merchant(merchantName);
        return merchantRepository.save(merchant);
    }

    public void paymentCustomer(PaymentCustomerRequest request) {
        Transaction transaction = new Transaction();
        transaction.setVaNumber(request.getVaNumber());
        transaction.setPaid(request.getPaid());
        transaction.setTimeStamp(LocalDateTime.now());

        transactionRepository.save(transaction);
    }
}
