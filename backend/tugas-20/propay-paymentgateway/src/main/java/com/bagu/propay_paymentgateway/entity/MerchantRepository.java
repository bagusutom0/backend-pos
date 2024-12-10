package com.bagu.propay_paymentgateway.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    Optional<Merchant> findByUcode(String ucode);
}
