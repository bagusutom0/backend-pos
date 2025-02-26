package com.bagus.point_of_sales.model.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//    Optional<Transaction> findByVaNumber(String vaNumber);
}
