package com.bagu.propay_paymentgateway.service;

import com.bagu.propay_paymentgateway.controller.PaymentCustomerRequest;
import com.bagu.propay_paymentgateway.controller.PaymentRequest;
import com.bagu.propay_paymentgateway.controller.VARequest;
import com.bagu.propay_paymentgateway.controller.VAResponse;
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

    public VA insertVa(VARequest request) {
        String ucode = request.getVaNumber().substring(0,4);
        Merchant merchant = merchantRepository.findByUcode(ucode)
                .orElseThrow(() -> new EntityNotFoundException("Merchant not found"));

        VA va = new VA();
        va.setMerchantId(merchant.getId());
        va.setVaNumber(request.getVaNumber());
        va.setPaymentDate(null);
        va.setAmount(request.getAmount());
        va.setPaymentCallBackUri(request.getPaymentCallbackUri());
        va.setCreatedDate(LocalDateTime.now());

        return vaRepository.save(va);
    }

    public VAResponse processPayment(PaymentRequest request) {
        Optional<VA> vaOptional = vaRepository.findByVaNumber(request.getVaNumber());
        if (vaOptional.isPresent()) {
            VA va = vaOptional.get();
            va.setPaymentDate(LocalDateTime.now());
            vaRepository.save(va);

            // notify merchant
            WebClient.Builder webClientBuilder = WebClient.builder();
            PaymentCustomerRequest paymentCustomerRequest = new PaymentCustomerRequest();
            paymentCustomerRequest.setVaNumber(request.getVaNumber());
            paymentCustomerRequest.setPaid(true);
            paymentCustomerRequest.setPaymentDate(LocalDateTime.now());

            webClientBuilder.build()
                    .post()
                    .uri(va.getPaymentCallBackUri())
                    .bodyValue(paymentCustomerRequest)
                    .retrieve()
                    .toBodilessEntity()
                    .doOnSuccess(response -> System.out.println("Merchant notified successfully"))
                    .doOnError(error -> System.err.println("Failed to notify merchant: " + error.getMessage()))
                    .subscribe();

            VAResponse vaResponse = new VAResponse();
            vaResponse.setVaNumber(va.getVaNumber());
            vaResponse.setAmount(0.0);
            return vaResponse;
        } else {
            throw new EntityNotFoundException("Virtual Account not found");
        }
    }
}
