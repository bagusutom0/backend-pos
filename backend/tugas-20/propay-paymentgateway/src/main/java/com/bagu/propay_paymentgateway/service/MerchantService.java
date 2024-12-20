package com.bagu.propay_paymentgateway.service;

import com.bagu.propay_paymentgateway.controller.RegisterRequest;
import com.bagu.propay_paymentgateway.controller.MerchantRequest;
import com.bagu.propay_paymentgateway.entity.Merchant;
import com.bagu.propay_paymentgateway.entity.MerchantRepository;
import com.bagu.propay_paymentgateway.entity.PaymentMethod;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
@Transactional
public class MerchantService {
    private final MerchantRepository merchantRepository;


    public MerchantService(MerchantRepository repository) {
        this.merchantRepository = repository;
    }

    public Merchant registerMerchant(MerchantRequest request) {
        String merchantUcode = "";
        do {
            merchantUcode = String.format("%04d", new Random().nextInt(10000));
            merchantUcode += String.valueOf(PaymentMethod.valueOf(request.getMethod()).ordinal());
        } while (merchantRepository.findByUcode(merchantUcode).isPresent()); // dapat menimbulkan infinite loop apabila merchant ucode sudah penuh

        String token = UUID.randomUUID().toString();
        Merchant merchant = Merchant.builder()
                .name(request.getName())
                .ucode(merchantUcode)
                .token(token)
                .method(PaymentMethod.valueOf(request.getMethod()))
                .build();

        WebClient.Builder webClientBuilder = WebClient.builder();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPgwName("ProPay");
        registerRequest.setMerchantUcode(merchantUcode);
        registerRequest.setToken(token);
        registerRequest.setMethod(request.getMethod());

        webClientBuilder.build()
                .post()
                .uri(request.getRegisterCallbackUri())
                .bodyValue(registerRequest)
                .retrieve()
                .toBodilessEntity()
                .doOnSuccess(response -> System.out.println("Merchant registered successfully"))
                .doOnError(error -> System.err.println("Failed to register merchant: " + error.getMessage()))
                .subscribe();

        return merchantRepository.save(merchant);
    }
}
