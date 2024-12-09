package com.bagu.propay_paymentgateway.service;

import com.bagu.propay_paymentgateway.controller.PaymentCustomerRequest;
import com.bagu.propay_paymentgateway.controller.VARequest;
import com.bagu.propay_paymentgateway.entity.Merchant;
import com.bagu.propay_paymentgateway.entity.MerchantRepository;
import com.bagu.propay_paymentgateway.entity.VA;
import com.bagu.propay_paymentgateway.entity.VARepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class VAService {
    @Autowired
    private VARepository vaRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    public String insertVa(VARequest request) {
        Merchant merchant = merchantRepository.findByName(request.getMerchantName())
                .orElseThrow(() -> new EntityNotFoundException("Merchant not found"));

        String vaNumber = UUID.randomUUID().toString();
        VA va = new VA();
        va.setMerchantId(merchant.getId());
        va.setVaNumber(vaNumber);
        va.setCustomerName(request.getCustomerName());
        va.setDescription(request.getDescription());
        va.setAmount(request.getAmount());
        va.setPaymentCallBackUri(request.getPaymentCallbackUri());
        va.setCreatedDate(LocalDateTime.now());

        vaRepository.save(va);

        return vaNumber;
    }

    public boolean isPaymentSuccess(String vaNumber) {
        Optional<VA> vaOptional = vaRepository.findByVaNumber(vaNumber);
        if (vaOptional.isPresent()) {
            VA va = vaOptional.get();
            va.setPaymentDate(LocalDateTime.now());
            vaRepository.save(va);

            // notify merchant
            WebClient.Builder webClientBuilder = WebClient.builder();
            PaymentCustomerRequest paymentCustomerRequest = new PaymentCustomerRequest();
            paymentCustomerRequest.setVaNumber(vaNumber);
            paymentCustomerRequest.setPaid(true);

            webClientBuilder.build()
                    .post()
                    .uri(va.getPaymentCallBackUri())
                    .bodyValue(paymentCustomerRequest)
                    .retrieve()
                    .toBodilessEntity()
                    .doOnSuccess(response -> System.out.println("Merchant notified successfully"))
                    .doOnError(error -> System.err.println("Failed to notify merchant: " + error.getMessage()))
                    .subscribe();


            return true;
        } else {
            return false;
        }
    }
}
