package com.bagus.merchant_paymentgateway.service;

import com.bagus.merchant_paymentgateway.controller.PgwRequest;
import com.bagus.merchant_paymentgateway.entity.PGW;
import com.bagus.merchant_paymentgateway.entity.PGWRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PGWService {
    private final PGWRepository repository;

    public PGW insertPgw(PgwRequest request) {
        PGW pgw = PGW.builder()
                .pgwName(request.getPgwName())
                .merchantUcode(request.getMerchantUcode())
                .build();

        return repository.save(pgw);
    }

    public String getMerchantUcode(String pgwName) {
        Optional<PGW> pgw = repository.findByPgwName(pgwName);
        if (pgw.isPresent()) {
            return pgw.get().getMerchantUcode();
        } else {
            return "";
        }
    }
}
