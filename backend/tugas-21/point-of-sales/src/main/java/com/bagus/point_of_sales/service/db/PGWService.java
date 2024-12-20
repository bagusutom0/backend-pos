package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.payment.PgwRequest;
import com.bagus.point_of_sales.model.payment.PGW;
import com.bagus.point_of_sales.model.payment.PGWRepository;
import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PGWService {
    private final PGWRepository pgwRepository;

    public PGW insertPgw(PgwRequest request) {
        PGW pgw = PGW.builder()
                .pgwName(request.getPgwName())
                .ucode(request.getMerchantUcode())
                .token(request.getToken())
                .method(PaymentMethod.valueOf(request.getMethod()))
                .build();

        return pgwRepository.save(pgw);
    }
}
