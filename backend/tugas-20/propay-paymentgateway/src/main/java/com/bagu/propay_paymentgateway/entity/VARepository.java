package com.bagu.propay_paymentgateway.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VARepository extends JpaRepository<VA, Integer> {
    Optional<VA> findByVaNumber(String vaNumber);
}
