package com.bagu.propay_paymentgateway.service;

import com.bagu.propay_paymentgateway.controller.RegisterRequest;
import com.bagu.propay_paymentgateway.controller.MerchantRequest;
import com.bagu.propay_paymentgateway.entity.Merchant;
import com.bagu.propay_paymentgateway.entity.MerchantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

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
        } while (merchantRepository.findByUcode(merchantUcode).isPresent()); // dapat menimbulkan infinite loop apabila merchant ucode sudah penuh

        Merchant merchant = Merchant.builder()
                .name(request.getName())
                .ucode(merchantUcode)
                .build();

        WebClient.Builder webClientBuilder = WebClient.builder();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPgwName("ProPay");
        registerRequest.setMerchantUcode(merchantUcode);

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
