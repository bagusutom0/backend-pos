package com.bagus.point_of_sales.model.payment;

import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PGWRepository extends JpaRepository<PGW, Long> {
    Optional<PGW> findByMethod(PaymentMethod method);
}
