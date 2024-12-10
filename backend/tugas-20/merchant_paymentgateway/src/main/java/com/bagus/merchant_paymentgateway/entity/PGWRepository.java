package com.bagus.merchant_paymentgateway.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PGWRepository extends JpaRepository<PGW, Long> {
    Optional<PGW> findByPgwName(String pgwName);
}
